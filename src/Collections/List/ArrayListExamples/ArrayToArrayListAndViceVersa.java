package Collections.List.ArrayListExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToArrayListAndViceVersa {
    public ArrayToArrayListAndViceVersa(){
        List<String> fruitList = new ArrayList<>();
        //adding String Objects to fruitsList ArrayList
        fruitList.add("Mango");
        fruitList.add("Banana");
        fruitList.add("Apple");
        fruitList.add("Strawberry");
        fruitList.add("Pineapple");

        System.out.println("Converting ArrayList to Array" );
       String[] item = fruitList.toArray(new String[fruitList.size()]);
        for (String s : item){
            System.out.println(s);
        }
        System.out.println("Comnverting Array to ArrayList ");
        List<String> l2 = new ArrayList<String>();
        l2 = Arrays.asList(item);
        System.out.println(l2);
    }
}
