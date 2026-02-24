package Collections.List.ArrayListExamples;

import java.util.ArrayList;

public class TypesToIterateList {
    public static void TypesToIterateListExamples(){
        System.out.println("TypesToIterateListExamples  Called. ");
        ArrayList<String> arrStr = new ArrayList<String>();
        arrStr.add("Ravi");
        arrStr.add("Vijay");
        arrStr.add("Ravi");
        arrStr.add("Ajay");

//        System.out.println("Iteration in reverse order. using While loop.");
//        ListIterator<String> list1 = arrStr.listIterator(arrStr.size());
//        while (list1.hasPrevious()){
//            System.out.println(list1.previous());
//        }

//        System.out.println("For loop.");
//        for(int i = 0 ; i < arrStr.size() ; i++){
//            System.out.println(arrStr.get(i));
//        }

//        System.out.println("For Each loop.");
//        arrStr.forEach(a -> {
//            System.out.println(a);
//        });

//        System.out.println("Iterator with for Each Remaining method. and with lambada expression.");
//       Iterator<String> itr = arrStr.iterator();
//        itr.forEachRemaining(a -> System.out.println(a));


    }


}
