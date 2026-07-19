package JAVA_8_Features.Generics;

public class BoundTypeParameterGenerics {
    public static void main(String[] args) {

//        System.out.println("Bound Type");
//        MathBox<Integer> intBox  = new MathBox<>(5);
//        MathBox<Double> doubleMathBox = new MathBox<>(4.5);
//        System.out.println("intBox = " + intBox.square());
//        System.out.println("doubleMathBox = " + doubleMathBox.square());

//         MathBox<String> stringBox = new MathBox<>("Hi");
//         COMPILE ERROR! String does not extend Number.

        //        2. Multiple Bounds
//        What if you need T to be a subclass of something and implement an interface?
//        You can chain them using the & operator.
//        Rule: If you use a class as a bound, it must come first, followed by interfaces.
        FindMaxClass<Number> findMaxClass = new FindMaxClass<>();
        Integer maxNumber = findMaxClass.findMax(3, 5);
        System.out.println("maxNumber = " + maxNumber);
    }

    // This means T can be Number, Integer, Double, Float, etc.
    // But it CANNOT be a String or a custom Customer class.
    public static class MathBox<T extends Number> {
        private T t;

        public MathBox(T i) {
            this.t = i;
        }

        public double square() {
            // Because T extends Number, Java guarantees that
            // the doubleValue() method exists!
            return t.doubleValue() * t.doubleValue();
        }
    }

    public static class FindMaxClass<T extends Number> {
        public <T extends Number & Comparable<T>> T findMax(T a, T b) {
            return (a.compareTo(b) > 0) ? a : b;
        }
    }
}
