package org.usfirst.frc.team2854.robot.modules.util;

/**
 * Created by Kevin on 10/24/2015.
 */
public class Vector{
  public final double x;
  public final double y;
  public final double angle;
  public final double radius;

  public Vector(double i, double j){
    x = i;
    y = j;
    angle = Math.atan2(y, x);
    radius = Math.sqrt(x*x+y*y);
  }

  public Vector add(Vector other){
    return new Vector(x+other.x, y+other.y);
  }

  public Vector scale(double s){
    return new Vector(x*s, y*s);
  }
}
