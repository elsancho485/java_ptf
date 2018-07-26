package ru.stqa.ptf.sandbox;

public class Point {


public double a;
public double b;
public double a1;
public double b1;

public Point(double a,double b,double a1,double b1) {

  this.a = a;
  this.b = b;
  this.a1 = a1;
  this.b1 = b1;

  }


  public double distance() {return Math.sqrt(Math.pow(this.a1 - this.a, 2) + Math.pow(this.b1 - this.b , 2));}



}
