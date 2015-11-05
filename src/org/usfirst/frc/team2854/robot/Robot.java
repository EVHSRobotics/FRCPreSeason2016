package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2854.robot.modules.SwerveDrive.SwerveDriveSubsystem;
import org.usfirst.frc.team2854.robot.modules.SwerveDrive.SwerveSubsystem;


/**
 * Created by Kevin on 10/23/2015.
 */
public class Robot extends IterativeRobot{
  public final SwerveDriveSubsystem swerveDriveSubsystem = new SwerveDriveSubsystem(new SwerveSubsystem("swerve0", RMap.Config.EPID, RMap.MA, RMap.MAA, RMap.EA),
                                                                                    new SwerveSubsystem("swerve1", RMap.Config.EPID, RMap.MB, RMap.MBB, RMap.EB),
                                                                                    new SwerveSubsystem("swerve2", RMap.Config.EPID, RMap.MC, RMap.MCC, RMap.EC),
                                                                                    new SwerveSubsystem("swerve3", RMap.Config.EPID, RMap.MD, RMap.MDD, RMap.ED),
                                                                                    RMap.GRobot);

  public static OI oi;

  private Command autonomousCommand;

  @Override
  public void robotInit(){
    super.robotInit();
    oi = new OI(); //need to wait for controllers to initialize

    autonomousCommand = null;
  }

  //auto
  @Override
  public void autonomousInit(){
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic(){
    Scheduler.getInstance().run();
  }

  //teleop
  @Override
  public void teleopInit(){
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic(){
    Scheduler.getInstance().run();
  }

  //disabled
  @Override
  public void disabledInit(){

  }

  @Override
  public void disabledPeriodic(){
    Scheduler.getInstance().run();
  }

  //testing
  @Override
  public void testInit(){

  }

  @Override
  public void testPeriodic(){
    LiveWindow.run();
  }
}
