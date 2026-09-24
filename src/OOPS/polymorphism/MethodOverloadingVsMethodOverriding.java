package OOPS.polymorphism;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }

    void showDetails() {
        System.out.println("Showing base calculator");
    }
}

class advancedCalculator extends Calculator {
    @Override
    void showDetails() {
        System.out.println("Showing advanced calculator");
    }
}

public class MethodOverloadingVsMethodOverriding {
    public static void main(String[] args) {
        Calculator basicCalc = new Calculator();
        System.out.println("Basic calculator");
        System.out.println("Sum of 2 ints: " + basicCalc.add(2, 2));
        System.out.println("Sum of 4 ints: " + basicCalc.add(4, 4));
        System.out.println("sum of 2 doubles: " + basicCalc.add(12.3, 15.2));

        // now showing overriding
        System.out.println("method overriding");
        advancedCalculator advancedCalculator = new advancedCalculator();
        advancedCalculator.showDetails();
    }
}
