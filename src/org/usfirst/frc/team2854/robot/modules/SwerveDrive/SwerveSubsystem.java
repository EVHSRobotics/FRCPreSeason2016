package org.usfirst.frc.team2854.robot.modules.SwerveDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team2854.robot.modules.NoopCommand;
import org.usfirst.frc.team2854.robot.modules.util.Vector;


/**
 * Created by Kevin on 10/23/2015.
 */
public class SwerveSubsystem extends PIDSubsystem{

  private static final double VERY_CLOSE_ENOUGH = 0.02454;
  private static final double CLOSE_ENOUGH = 0.1963;
  private static final double TAU = Math.PI*2;

  private final SpeedController driveControl;
  private final SpeedController turnControl;
  private final Gyro gyro;

  public SwerveSubsystem(String name, double p, double i, double d, SpeedController aDriveControl, SpeedController aTurnControl, Gyro aGyro){
    super(name, p, i, d);

    driveControl = aDriveControl;
    turnControl = aTurnControl;

    gyro = aGyro;
  }

  public void setTargetState(Vector aVector){
    double angle = aVector.angle;
    double current = gyro.getAngle();
    double difference = angle-Math.toRadians(current%360);
    if(difference > Math.PI) {
      angle = Math.toRadians(current)-TAU+difference;
    } else if(difference < -Math.PI) {
      angle = Math.toRadians(current)+TAU-difference;
    } else {
      angle = Math.toRadians(current)+difference;
    }
    setSetpoint(angle);
    driveControl.set(Math.min(Math.abs(aVector.radius), 1)*Math.signum(aVector.radius));
  }

  @Override
  protected double returnPIDInput(){
    return Math.toRadians(gyro.getAngle());
  }

  @Override
  protected void usePIDOutput(double v){

  }

  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(new NoopCommand());
  }
}
