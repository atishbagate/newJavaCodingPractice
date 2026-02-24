package Collections.List.ListExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public ListExample() {
       List<String> list = new ArrayList<String>();
       list.add("Mango");
       list.add("Apple");
       list.add("Graps");

//       for(String fruit:list){
//           System.out.println(fruit);
//       }

       //get set
        System.out.println(list.get(2));
        list.set(2,"banana");
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

    }
}
