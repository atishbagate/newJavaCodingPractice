package Collections.TreeSetExamples;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetMain {
public  TreeSetMain() {
    System.out.println("TreeSetMain Example.");


    TreeSet treeSet = new TreeSet();

    treeSet.add("Atish");
    treeSet.add("Vaibhav");
    treeSet.add("treeSet");

    Iterator<String> treeSetItr = treeSet.iterator();
    while(treeSetItr.hasNext()){
        System.out.println(treeSetItr.next());
    }

    System.out.println("Reverse Iterator.");
    //reverse order
   Iterator<String> descTreeSet = treeSet.descendingIterator();
    while (descTreeSet.hasNext()){
        System.out.println(descTreeSet.next());
    }



 }
}
