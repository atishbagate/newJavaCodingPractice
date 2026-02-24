package Collections.Set.HashSetExample;

import java.util.HashSet;

class Book{
    int id;
    String name;
    int quantity;
    public Book(int id,String name,int quantity){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
public class HashSetBook {

    public HashSetBook() {

        Book b1 = new Book(1, "jim quick", 2);
        Book b2 = new Book(2, "Harry", 4);

        HashSet<Book> set = new HashSet<Book>();
        set.add(b1);
        set.add(b2);

        for(Book b:set){
            System.out.println(b.id+ " - "+b.name+" - "+b.quantity);
        }
    }
}
