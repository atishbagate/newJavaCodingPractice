package Collections.List.LinkedListExamples;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public LinkedListExample(){
  LinkedList<String> linkedArry  = new LinkedList<String>();
        linkedArry.add("Ram");
        linkedArry.add("Sham");
        linkedArry.add("Ravi");

//      Iterator itrList = linkedArry.iterator();
//        while (itrList.hasNext()){
//            System.out.println(itrList.next());
//        }
//        linkedArry.add(1,"harry");
//        Iterator itrList = linkedArry.iterator();
//        while (itrList.hasNext()){
//            System.out.println(itrList.next());
//        }
//        LinkedList<String> secondArry  = new LinkedList<String>();
//        secondArry.add("Mina");
//        secondArry.add("Teena");
//        linkedArry.addAll(secondArry);
//        Iterator itrList = linkedArry.iterator();
//        while (itrList.hasNext()){
//            System.out.println(itrList.next());
//        }
//        linkedArry.addFirst("ramu");
//        linkedArry.addLast("shamu");
//        Iterator itrList = linkedArry.iterator();
//        while (itrList.hasNext()){
//            System.out.println(itrList.next());
//        }

        //remove
//        linkedArry.removeFirst();
//        linkedArry.removeLast();
//        linkedArry.removeFirstOccurrence("Ram");
//        linkedArry.removeLastOccurrence("Ravi");
//        System.out.println(linkedArry);


        // reversing LinkedList
     Iterator i  = linkedArry.descendingIterator();
     while (i.hasNext()){
         System.out.println(i.next());
     }
    }
}
