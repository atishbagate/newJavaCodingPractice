package Collections.ArrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class SortingArrayList {
    public SortingArrayList(){
       ArrayList<String> list = new ArrayList<String>();
        list.add("Volkswagen");
        list.add("Toyota");
        list.add("Porsche");
        list.add("Ferrari");
        list.add("Mercedes-Benz");
        list.add("Audi");

        System.out.println("Before Sort : "+ list);

        Collections.sort(list);

        System.out.println("After Sort : "+list);

        Collections.sort(list,Collections.reverseOrder());

        System.out.println("Reverse Sorting : "+ list);

    }
}
