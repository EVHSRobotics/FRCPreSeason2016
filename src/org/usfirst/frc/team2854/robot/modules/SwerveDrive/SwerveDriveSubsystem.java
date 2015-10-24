package org.usfirst.frc.team2854.robot.modules.SwerveDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2854.robot.modules.NoopCommand;


/**
 * Created by Kevin on 10/23/2015.
 */
public class SwerveDriveSubsystem extends Subsystem{

  private final SwerveSubsystem swerve1;
  private final SwerveSubsystem swerve2;
  private final SwerveSubsystem swerve3;
  private final SwerveSubsystem swerve4;

  public SwerveDriveSubsystem(SwerveSubsystem aSwerve1, SwerveSubsystem aSwerve2, SwerveSubsystem aSwerve3, SwerveSubsystem aSwerve4){
    swerve1 = aSwerve1;
    swerve2 = aSwerve2;
    swerve3 = aSwerve3;
    swerve4 = aSwerve4;
  }

  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(new NoopCommand());
  }
}
