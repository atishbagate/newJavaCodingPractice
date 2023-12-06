package Collections.TreeSetExamples;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMethods {
    public TreeSetMethods(){
        TreeSet<String> set=new TreeSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");

        System.out.println("Initial Set: "+set);
        System.out.println("headSet Set: "+set.headSet("C",true));
//        System.out.println("lower Set: "+set.lower("B"));
//        System.out.println("higher Set: "+set.higher("B"));

        System.out.println("pollFirst Set: "+set.pollFirst());
        System.out.println("pollLast Set: "+set.pollLast());
        System.out.println("after Polling Set: "+set);

//       NavigableSet<String> subset1 = (NavigableSet<String>) set.subSet("B","D");
        NavigableSet<String> subset1 =  set.tailSet("B",true);
     Iterator itr1 = subset1.iterator();
       while (itr1.hasNext()){
           System.out.println(itr1.next());
       }
    }
}
