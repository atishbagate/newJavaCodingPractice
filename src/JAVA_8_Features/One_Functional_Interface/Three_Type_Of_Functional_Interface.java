package JAVA_8_Features.One_Functional_Interface;


// there are total 5 types of Functional interface.
//1. Consumer : it is an operation that accept one input and return nothing.
//2. Supplier : it is an operation that not accept any input but return value of type T.
//3. Functional : it accepts one parameter and return result.
//4. Predicate : it accepts value and return boolean.
//5. custom functional interface : must have only one abstract method.


//1. Consumer
@FunctionalInterface
interface Consumer<T> {
    void accept(T input);
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}

@FunctionalInterface
interface Functional<T, R> {
    R function(T input);
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

// custom fnuctional interface
@FunctionalInterface
interface MathOperation {
    // Exactly one abstract method (public abstract implicitly)
    int operate(int a, int b);
}

public class Three_Type_Of_Functional_Interface {
    public static void main(String[] args) {
        System.out.println("Types of Functional interface.");

//        1. consumer
//        Consumer<Integer> consumer = (number) -> {
//            System.out.println("this is consumer Interface type :  "+number);
//        };
//        consumer.accept(100);


//        2. Supplier
//       Supplier<Integer> supplier = () -> 100;
//       Integer valueOfSupplier = supplier.get();
//        System.out.println(valueOfSupplier);

//        3. functional
//        Functional<String,Integer> functional = (String input) -> Integer.parseInt(input);
//        Integer valueOfFunction = functional.function("100");
//        System.out.println("value of function is: " + valueOfFunction+" - "+ valueOfFunction.getClass().getSimpleName());

//        4. Predicate
//        Predicate<Integer> predicateFunction = value -> value % 2 == 0;
//       boolean value = predicateFunction.test(100);
//        System.out.println("value of function is: " + value);

//        5. custom functinoal interface
//        MathOperation mathOperation = (v1, v2) -> {
//            return v1 + v2;
//        };
//       int finalValue = mathOperation.operate(10, 20);
//        System.out.println(finalValue);
    }
}
