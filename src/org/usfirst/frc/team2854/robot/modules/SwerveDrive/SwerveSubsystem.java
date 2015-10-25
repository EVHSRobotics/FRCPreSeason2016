package org.usfirst.frc.team2854.robot.modules.SwerveDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team2854.robot.modules.NoopCommand;
import org.usfirst.frc.team2854.robot.modules.util.Vector;
import org.usfirst.frc.team2854.robot.modules.util.Vector3;


/**
 * Created by Kevin on 10/23/2015.
 */
public class SwerveSubsystem extends PIDSubsystem{

  private static final double VERY_CLOSE_ENOUGH = 0.02454;
  private static final double CLOSE_ENOUGH = 0.1963;
  private static final double TAU = Math.PI*2;
  private static final double ENCODER_TAU = 250; // !!! NEED TO MODIFY THIS VALUE !!!

  private final SpeedController driveControl;
  private final SpeedController turnControl;
  private final Encoder encoder;

  public SwerveSubsystem(String name, Vector3 aVector3, SpeedController aDriveControl, SpeedController aTurnControl, Encoder aEncoder){
    super(name, aVector3.x, aVector3.y, aVector3.z);

    driveControl = aDriveControl;
    turnControl = aTurnControl;

    encoder = aEncoder;
  }

  public void setTargetState(Vector aVector){
    double angle = aVector.angle;
    double current = encoderToRadians(encoder.getRaw());
    double difference = angle-current;
    if(difference > Math.PI) {
      angle = current-TAU+difference;
    } else if(difference < -Math.PI) {
      angle = current+TAU-difference;
    } else {
      angle = current+difference;
    }
    setSetpoint(angle);
    driveControl.set(Math.min(Math.abs(aVector.radius), 1)*Math.signum(aVector.radius));
  }

  public static double encoderToRadians(double encoderRaw){
    return encoderRaw/ENCODER_TAU*TAU;
  }


  @Override
  protected double returnPIDInput(){
    return encoderToRadians(encoder.getRaw());
  }

  @Override
  protected void usePIDOutput(double v){

  }

  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(new NoopCommand());
  }
}
