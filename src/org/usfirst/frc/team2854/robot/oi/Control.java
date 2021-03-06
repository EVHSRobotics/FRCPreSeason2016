package org.usfirst.frc.team2854.robot.oi;

import edu.wpi.first.wpilibj.Joystick;


/**
 * Created by Kevin on 10/23/2015.
 */
public abstract class Control{
  public final Joystick joystick;

  public Control(Joystick aJoystick){
    joystick = aJoystick;
  }

  public static int evaluateButtonType(ButtonType aButtonType){
    switch(aButtonType) {
      case a:
        return 0;
      case b:
        return 1;
      case x:
        return 2;
      case y:
        return 3;
      case lb:
        return 4;
      case rb:
        return 5;
      case back:
        return 6;
      case start:
        return 7;
// these are activated when pressing down the sticks
      case ls:
        return 8;
      case rs:
        return 9;
      default:
        return -1;
    }
  }

  public static int evaluateAxisType(AxisType aAxisType){
    switch(aAxisType) {
// these return values from -1 to 1
//     -1
//      ^
// -1 < o > 1
//      v
//      1
//
      case lx:
        return 0;
      case ly:
        return 1;
      case rx:
        return 4;
      case ry:
        return 5;
// these return values from 0 to 1
      case lt:
        return 2;
      case rt:
        return 3;
      default:
        return -1;
    }
  }
}
