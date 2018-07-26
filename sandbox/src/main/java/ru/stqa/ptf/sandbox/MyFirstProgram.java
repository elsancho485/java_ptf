package ru.stqa.ptf.sandbox;

import com.sun.tools.jdi.SocketAttachingConnector;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Sashka");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

    Point p = new Point(16, 20, 24, 14);
    System.out.println("Расстояние между точками A и B на двухмерной плоскости равняется " + p.distance());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

        
}