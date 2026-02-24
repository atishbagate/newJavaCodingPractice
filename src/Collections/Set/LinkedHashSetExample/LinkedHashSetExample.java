package Collections.Set.LinkedHashSetExample;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public LinkedHashSetExample(){
        // Creating an empty LinekdhashSet of string type
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Java");
        lhs.add("T");
        lhs.add("Point");
        lhs.add("Good");
        // displaying all the elements on the console
//        System.out.println("The hash set is: " + lhs);

        Iterator<String> itr=lhs.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
