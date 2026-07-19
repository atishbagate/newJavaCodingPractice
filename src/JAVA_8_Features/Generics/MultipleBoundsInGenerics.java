package JAVA_8_Features.Generics;

import java.util.ArrayList;
import java.util.List;

public class MultipleBoundsInGenerics {
    // the multiple bound restriction:
    // T must extend number and implement comparable<T>
    public static <T extends Number & Comparable<T>> List<T> filterGreaterThan(List<T> list, T threshold) {
        List<T> result = new ArrayList<T>();
        for (T t : list) {
            if (t.compareTo(threshold) > 0) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1. Works perfectly with Integers (Integer extends Number and implements Comparable)
        List<Integer> numbers = List.of(10, 25, 5, 40, 20);
        List<Integer> result = filterGreaterThan(numbers, 20);
        System.out.println(result);

        // 2. testing Double type also
        List<Double> decimals = List.of(10.0, 25.0, 50.0, 40.0, 20.0);
        List<Double> largerDecimals = filterGreaterThan(decimals, 20.0);
        System.out.println(largerDecimals);
    }
}
