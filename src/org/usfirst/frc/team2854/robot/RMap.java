package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;
import org.usfirst.frc.team2854.robot.modules.util.Vector3;


/**
 * Created by Kevin on 10/24/2015.
 */
public class RMap{
  public static final Talon MA = new Talon(0);
  public static final Talon MB = new Talon(1);
  public static final Talon MC = new Talon(2);
  public static final Talon MD = new Talon(3);
  public static final CANTalon MAA = new CANTalon(1);
  public static final CANTalon MBB = new CANTalon(2);
  public static final CANTalon MCC = new CANTalon(3);
  public static final CANTalon MDD = new CANTalon(4);

  public static final Gyro GRobot = new Gyro(0);

  public static final Encoder EA = new Encoder(1, 2, false, CounterBase.EncodingType.k4X);
  public static final Encoder EB = new Encoder(3, 4, false, CounterBase.EncodingType.k4X);
  public static final Encoder EC = new Encoder(5, 6, false, CounterBase.EncodingType.k4X);
  public static final Encoder ED = new Encoder(7, 8, false, CounterBase.EncodingType.k4X);

  public static final class Config{
    public static final Vector3 EPID = new Vector3(0.0245, 0.001, 0.01);
  }
}
