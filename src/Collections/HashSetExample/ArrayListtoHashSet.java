package Collections.HashSetExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArrayListtoHashSet {
    public ArrayListtoHashSet(){

    ArrayList<String> arrList = new ArrayList<String>();
    arrList.add("Ram");
    arrList.add("Sham");

  HashSet<String> set = new HashSet<String>(arrList);

  Iterator<String> itrList  = arrList.iterator();
  while(itrList.hasNext()){
      System.out.println(itrList.next());
  }
    }
}
