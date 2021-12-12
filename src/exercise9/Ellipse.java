package exercise9;

import java.lang.Math;



import java.awt.Point;

public class Ellipse {
    private Point startPoint;
    private double a;
    private double b;

    public Ellipse()  {
        startPoint= new Point(0,0);
        a = 1;
        b = 1;
    }

    public Ellipse (Point startPoint, double a, double b) {
        this.startPoint = new Point(startPoint);
        this.a = a;
        this.b = b;

    }

    public Ellipse (Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        this.a = otherEllipse.a;
        this.b = otherEllipse.b;
    }

    public boolean isValid () {
        return a > 0 && b > 0;
    }

    public void initialize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter height: ");
            a = Utils.INPUT.nextDouble();
            System.out.print("Enter width: ");
            b = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        double perimeter = Math.PI*(3*(a+b) - Math.sqrt((3*a + b)*(a + 3*b)));
        return perimeter;
    }

    public double calculateArea () {
        double area = Math.PI*a*b;
        return area;
    }

    public String getType() {
        if (a==b) {
            return "Circle";
        } else {
            return "Ellipse";
        }
    }

    public String toString() {
        return String.format("(%s, %s)-[%s,%s], %s, P=%s, A=%s", startPoint.x, startPoint.y, a, b, getType(), calculatePerimeter(), calculateArea());

    }

    public boolean equals(Ellipse otherellipse) {

        boolean sameWidth = Utils.equals(a, otherellipse.a);
        boolean sameHeight = Utils.equals(b, otherellipse.b);

        return (sameHeight && sameWidth);

    }


}
