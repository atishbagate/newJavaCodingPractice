package OOPS.abstraction.UsingAbstractClass;

public class ShareAreaCalculator {

//    This is abstract class
    static  abstract  class Shape{
        String shapeName;

        Shape(String name){
            this.shapeName = name;
        }
        abstract double calculateArea();
        void  display(){
            System.out.println("Shape - "+shapeName);
            System.out.println("Calculated Area "+calculateArea());
            System.out.println("------");
        }
    }
//    concrete class
    static  class Circle extends Shape{
        double radious;
        Circle(double radious){
            super("Circle");
            this.radious = radious;
        }
        @Override
        double calculateArea() {
            return Math.PI * radious * radious;
        }
    }
//    concrete class
    static class Triangle extends Shape{
        double height, base;
       Triangle(double height, double base){
            super("Triangle");
            this.height = height;
            this.base = base;
        }
        @Override
        double calculateArea(){
           return (height*base)/2;
        }
   }
   static class  Rectangle extends Shape{
        double length, width;
        Rectangle(double l, double w) {
            super("Rectangle");
            this.length = l;
            this.width = w;
        }
        @Override
       double calculateArea(){
            return length*width;
        }
   }
   public static void main(String[] args){

        Shape circleArea = new Circle(12.3);
        Shape rectangle = new Rectangle(10,20);

        circleArea.display();
        rectangle.display();
   }
}
