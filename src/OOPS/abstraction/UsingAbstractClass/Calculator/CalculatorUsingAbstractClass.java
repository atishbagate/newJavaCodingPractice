package OOPS.abstraction.UsingAbstractClass.Calculator;

class Circle {
    // encapsulated data
    private double radius;

    //getter
    public double getRadius() {
        return radius;
    }

    //setter
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    // logic
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

public class CalculatorUsingAbstractClass {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5);
        System.out.println("Radius : " + circle.getRadius());
        System.out.println("The area of the circle is: " + circle.calculateArea());
    }
}
