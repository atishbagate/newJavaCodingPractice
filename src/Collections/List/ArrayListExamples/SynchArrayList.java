package Collections.List.ArrayListExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchArrayList {
     public SynchArrayList(){
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Mango");
        fruitList.add("Banana");
        fruitList.add("Apple");
        fruitList.add("Strawberry");
        fruitList.add("Pineapple");


        fruitList =  Collections.synchronizedList(fruitList);

        synchronized (fruitList){
          Iterator<String> itr = fruitList.iterator();
          while (itr.hasNext()){
              System.out.println(itr.next());
          }
        }
    }
}
