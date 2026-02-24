package Collections.Queue.DequeExamples;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExamples {
    public DequeExamples(){
        Deque<String> deqArr =  new ArrayDeque<String>();

        deqArr.add("Ram");
        deqArr.add("Vijay");
        deqArr.add("Ajay");

        System.out.println("deqArr");
        for(String i:deqArr){
            System.out.println(i);
        }
        System.out.println("offer");
        deqArr.offer("Ganu");
        for(String i:deqArr){
            System.out.println(i);
        }
        System.out.println("offer first");
        deqArr.offerFirst("Harry");
        for(String i:deqArr){
            System.out.println(i);
        }
        System.out.println("offer last");
        deqArr.offerLast("Shayam");
        for(String i:deqArr){
            System.out.println(i);
        }
        System.out.println("Poll Last");
        deqArr.pollLast();
        for(String i:deqArr){
            System.out.println(i);
        }
    }
}
