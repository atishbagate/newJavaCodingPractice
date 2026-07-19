package JAVA_8_Features.Generics;


//1. generic classes
public class Generics_Box {

    public static void main(String[] args) {

        // string box
//       Box<String> stringBox = new Box<>();
//       stringBox.SetBox("Hello");
//       String BoxDtl = stringBox.getT();
//        System.out.println(BoxDtl);

        // integer box
//      Box<Integer> intBox  = new Box();
//      intBox.SetBox(10);
//      Integer BoxDtl2 = intBox.getT();
//      System.out.println(BoxDtl2);

        // method type
//        String[] names = {"Hello","World"};
//        Integer[] numbers = {1,2,3,4,5,6,7};
//        Box<String> stringBox2 = new Box<>();
//        stringBox2.printArray(names);
//        stringBox2.printArray(numbers);

    }

    public static class Box<T> {
        private T t;

        public void SetBox(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        // 2. Generic Methods - type for specific method only.
        public <T> void printArray(T[] array) {
            for (T t : array) {
                System.out.println(t + " ");
            }
            System.out.println();
        }
    }

}
