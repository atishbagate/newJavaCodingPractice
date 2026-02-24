package Collections.Set.HashSetExample;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {
    public HashSetMain(){
       HashSet<String> set = new HashSet<String>();
       set.add("Ram");
       set.add("Sham");
       set.add("Harry");


//       ignore dupliocate entry
        set.add("Sham");
        set.add("Harry");

    Iterator<String> itr  = set.iterator();

    while(itr.hasNext()){
        System.out.println(itr.next());
    }

    }
}
