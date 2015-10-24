package org.usfirst.frc.team2854.robot.modules.SwerveDrive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team2854.robot.modules.NoopCommand;


/**
 * Created by Kevin on 10/23/2015.
 */
public class SwerveSubsystem extends PIDSubsystem{

  private final SpeedController driveControl;
  private final SpeedController turnControl;

  public SwerveSubsystem(String name, double p, double i, double d, SpeedController aDriveControl, SpeedController aTurnControl){
    super(name, p, i, d);

    driveControl = aDriveControl;
    turnControl = aTurnControl;
  }

  @Override
  protected double returnPIDInput(){
    return 0;
  }

  @Override
  protected void usePIDOutput(double v){

  }

  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(new NoopCommand());
  }
}
