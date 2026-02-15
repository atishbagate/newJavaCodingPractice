package OOPS.polymorphism;

public class CalculatorSystem {
    static class MathOperator{
        int add(int a,int b){return a+b;}
        int add(int a, int b, int c){return a+b+c;}
        double add(double a,double b){return a+b;}
    }

    static class Print {
        void print(){
            System.out.println("print is in black and white.");
        }
    }
    static class ColorPrinter extends Print{
        @Override
        void print(){
            System.out.println("Print in colors.");
        }
    }

    public static void main(String[] args) {
        MathOperator mathOps = new MathOperator();

//        overloadingexample
        System.out.println(mathOps.add(1,2,3));
        System.out.println(mathOps.add(1.2,2.3));

//        overriding example
        Print myPrint = new ColorPrinter();
        myPrint.print();
    }
}
