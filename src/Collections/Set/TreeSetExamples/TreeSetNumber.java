package Collections.Set.TreeSetExamples;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetNumber {
    public TreeSetNumber(){
       TreeSet<Number> setNumber = new TreeSet<Number>();

       setNumber.add(12);
       setNumber.add(33);
       setNumber.add(10);
       setNumber.add(40);
       setNumber.add(55);
       setNumber.add(68);

       System.out.println("Lowest Value "+setNumber.pollFirst());
       System.out.println("Highest Value "+setNumber.pollLast());

       Iterator<Number> itr = setNumber.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
