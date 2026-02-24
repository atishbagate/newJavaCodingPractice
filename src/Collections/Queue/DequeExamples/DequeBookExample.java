package Collections.Queue.DequeExamples;

import java.util.ArrayDeque;
import java.util.Deque;

class Book{
    int id;
    String name;

    public Book(int id,String name){
        this.id=id;
        this.name=name;
    }
}

public class DequeBookExample {
    public DequeBookExample(){

     Deque<Book> deqArr =  new ArrayDeque<Book>();

        //Creating Books
        Book b1=new Book(101,"Let us C");
        Book b2=new Book(102,"Data Communications & Networking");
        Book b3=new Book(103,"Operating System");

        deqArr.add(b1);
        deqArr.add(b2);
        deqArr.add(b3);

        for(Book i:deqArr){
            System.out.println(i.id+" - "+i.name);
        }



    }
}
