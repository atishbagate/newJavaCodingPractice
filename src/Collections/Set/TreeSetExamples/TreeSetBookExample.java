package Collections.Set.TreeSetExamples;

import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{
    int id;
    String name,author;
    int unit;

    public Book(int id, String name,String author,int unit){
        this.id =  id;
        this.name=name;
        this.author = author;
        this.unit= unit;
    }

//    implementing the abstract method
    @Override
    public int compareTo(Book b) {
        if(id>b.id) {
            return 1;
        } else if (id<b.id){
            return  -1;
        } else {
            return 0;
        }
    }
}

public class TreeSetBookExample {
    public TreeSetBookExample(){

        Set<Book> set=new TreeSet<>();

        //Creating Books
        Book b1=new Book(121,"Let us C","Yashwant Kanetkar",8);
        Book b2=new Book(233,"Operating System","Galvin", 6);
        Book b3=new Book(101,"Data Communications & Networking","Forouzan",4);
     //Adding Books to TreeSet
        set.add(b1);
        set.add(b2);
        set.add(b3);

   for (Book b:set){
       System.out.println(b.id+" "+b.name+" "+b.author+" "+b.unit);
   }
    }
}
