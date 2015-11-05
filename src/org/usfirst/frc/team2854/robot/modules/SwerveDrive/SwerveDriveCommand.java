package org.usfirst.frc.team2854.robot.modules.SwerveDrive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2854.robot.modules.util.Vector;
import org.usfirst.frc.team2854.robot.oi.Axis;


/**
 * Created by Kevin on 11/4/2015.
 */
public class SwerveDriveCommand extends Command{
  private SwerveDriveSubsystem swerveDrive;
  private Axis xAxis;
  private Axis yAxis;
  private Axis lAxis;
  private Axis rAxis;

  public SwerveDriveCommand(SwerveDriveSubsystem aSwerveDriveSubsystem, Axis aXAxis, Axis aYAxis, Axis aLAxis, Axis aRAxis){
    swerveDrive = aSwerveDriveSubsystem;
    xAxis = aXAxis;
    yAxis = aYAxis;
    lAxis = aLAxis;
    rAxis = aRAxis;
  }

  @Override
  protected void initialize(){
    requires(swerveDrive);
    swerveDrive.start();
  }


  @Override
  protected void execute(){
    swerveDrive.drive(swerveDrive.genPlan(new Vector(xAxis.deadbandGet(), -yAxis.deadbandGet()), lAxis.deadbandGet()-rAxis.deadbandGet()));
  }

  @Override
  protected boolean isFinished(){
    return false;
  }

  @Override
  protected void end(){
    swerveDrive.stop();
  }

  @Override
  protected void interrupted(){
    swerveDrive.stop();
  }
}
