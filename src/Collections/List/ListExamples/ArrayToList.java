package Collections.List.ListExamples;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {
public ArrayToList(){

    Integer[] intArr = {1,4,6,2,9,7,5};
    List<Integer> listArr = new ArrayList<Integer>();

    for (Integer list:intArr){
        listArr.add(list);
    }

    System.out.println(listArr);

//    converting list to Array

    Integer[] arr = listArr.toArray(new Integer[listArr.size()]);
//    System.out.println("in arr - "+ Arrays.toString(arr));
    for(Integer item:arr){
        System.out.println(item);
    }

}
}
