package Collections.Queue.PriorityQueueExample;

import java.util.PriorityQueue;
import java.util.Queue;

class Book implements Comparable<Book>{
    int id;
    String name;

    public Book(int id,String name){
        this.id= id;
        this.name= name;
    }

    @Override
    public int compareTo(Book b) {
        if(id>b.id){
            return 1;
        } else if (id<b.id) {
            return  -1;
        } else {
            return 0;
        }
    }
}

public class PriorityQueueBookExample {
    public PriorityQueueBookExample(){

        Queue<Book> queue=new PriorityQueue<Book>();

        Book b1=new Book(121,"Let us C");
        Book b2=new Book(233,"Operating System");
        Book b3=new Book(101,"Data Communications & Networking");

        queue.add(b1);
        queue.add(b2);
        queue.add(b3);
        System.out.println("Traversing the queue elements:");
        //Traversing queue elements
        for(Book b:queue){
            System.out.println(b.id+" "+b.name);
        }
        queue.remove();
        System.out.println("After removing one book record:");
        for(Book b:queue){
            System.out.println(b.id+" "+b.name);
        }
    }
}
