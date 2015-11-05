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

  private final SwerveSubsystem swerve0;
  private final SwerveSubsystem swerve1;
  private final SwerveSubsystem swerve2;
  private final SwerveSubsystem swerve3;

  private final Gyro gyro;

  public SwerveDriveSubsystem(SwerveSubsystem aSwerve0, SwerveSubsystem aSwerve1, SwerveSubsystem aSwerve2, SwerveSubsystem aSwerve3, Gyro aGyro){
    swerve0 = aSwerve0;
    swerve1 = aSwerve1;
    swerve2 = aSwerve2;
    swerve3 = aSwerve3;

    gyro = aGyro;
  }

  /**
   * generate movement vectors for each swerve subsystem
   * vectors should already be adjusted for rotation via gyro
   *
   * @param trans translation vector of controller [x, y] coordinates
   * @param rot rotation vector [x] in counterclockwise (positive) or clockwise (negative)
   * @return array of 4 vectors for each wheel
   */
  public Vector[] genPlan(Vector trans, double rot){
    //adjust for rotation of robot using gyro
    double a = -Math.toRadians(gyro.getAngle()%360);
    Vector[] vectors = new Vector[4];
    for(int i = 0; i < vectors.length; i++) {
      vectors[i] = trans.add(rotVectors[i].scale(rot)).addAngle(a);
    }
    //find if any magnitude exceeds 1
    double max = 0;
    for(int i = 0; i < vectors.length; i++) {
      max = Math.max(max, Math.abs(vectors[i].radius));
    }
    //scale vectors to less than 1 if needed
    if(max > 1) {
      double reciprocal = 1/max;
      for(int i = 0; i < vectors.length; i++) {
        vectors[i] = vectors[i].scale(reciprocal);
      }
    }
    return vectors;
  }

  // 0    1
  // 0----0
  // |    |
  // |    |
  // 0----0
  // 3    2
  /**
   * broadcasts the state of each swerve subsystem
   * @param vectors array of 4 vectors for each of the swerve subsystems
   */
  public void drive(Vector[] vectors){
    swerve0.setTargetState(vectors[0]);
    swerve1.setTargetState(vectors[1]);
    swerve2.setTargetState(vectors[2]);
    swerve3.setTargetState(vectors[3]);
  }

  @Override
  protected void initDefaultCommand(){
    setDefaultCommand(new NoopCommand());
  }
}
