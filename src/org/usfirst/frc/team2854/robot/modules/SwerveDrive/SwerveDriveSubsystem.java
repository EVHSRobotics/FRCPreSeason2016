package org.usfirst.frc.team2854.robot.modules.SwerveDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2854.robot.modules.NoopCommand;
import org.usfirst.frc.team2854.robot.modules.util.Vector;


/**
 * Created by Kevin on 10/23/2015.
 */
public class SwerveDriveSubsystem extends Subsystem{
  private static final Vector[] rotVectors = {new Vector(-1, -1), new Vector(-1, 1), new Vector(1, 1), new Vector(1, -1)};

  private final SwerveSubsystem swerve1;
  private final SwerveSubsystem swerve2;
  private final SwerveSubsystem swerve3;
  private final SwerveSubsystem swerve4;
  private final Gyro gyro;

  public SwerveDriveSubsystem(SwerveSubsystem aSwerve1, SwerveSubsystem aSwerve2, SwerveSubsystem aSwerve3, SwerveSubsystem aSwerve4, Gyro aGyro){
    swerve1 = aSwerve1;
    swerve2 = aSwerve2;
    swerve3 = aSwerve3;
    swerve4 = aSwerve4;

    gyro = aGyro;
  }

  public Vector[] genPlan(Vector trans, double rot){
    Vector[] vectors = new Vector[4];
    for(int i = 0; i < vectors.length; i++) {
      vectors[i] = trans.add(rotVectors[i].scale(rot));
    }
    double max = 0;
    for(int i = 0; i < vectors.length; i++) {
      max = Math.max(max, Math.max(Math.abs(vectors[i].x), Math.abs(vectors[i].y)));
    }
    if(max > 1) {
      double reciprocal = 1/max;
      for(int i = 0; i < vectors.length; i++) {
        vectors[i] = vectors[i].scale(reciprocal);
      }
    }
    return vectors;
  }

  // 1    2
  // 0----0
  // |    |
  // |    |
  // 0----0
  // 4    3
  public void drive(Vector v1, Vector v2, Vector v3, Vector v4){
    swerve1.setTargetState(v1);
    swerve2.setTargetState(v2);
    swerve3.setTargetState(v3);
    swerve4.setTargetState(v4);
  }

  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(new NoopCommand());
  }
}

/**
 * If you wanted...
 * You could have this constant value that's added to the gyro
 * Equal to the difference between the value when you reset it and 360
 */
