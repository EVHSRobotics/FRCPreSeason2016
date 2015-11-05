package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team2854.robot.oi.Controller;


/**
 * Created by Kevin on 10/23/2015.
 */
public class OI{
  public final Controller controller0;
//  public final Controller controller1;

  public OI(){
    controller0 = new Controller(new Joystick(0), 0.05);
//    controller1 = new Controller(new Joystick(1), 0.05);
  }
}
