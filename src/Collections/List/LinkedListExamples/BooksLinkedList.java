package Collections.List.LinkedListExamples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Book {
    int id;
    String name;
    int quantity;
public Book(int id, String name,int quantity) {
this.id= id;
this.name = name;
this.quantity = quantity;
}
}
public class BooksLinkedList {

    public  BooksLinkedList() {


        Book b1 = new Book(1, "ABC", 2);

        Book b2 = new Book(2, "XYZ", 4);
        List<Book> list = new LinkedList<Book>();

        list.add(b1);
        list.add(b2);

        Iterator BookList  = list.iterator();

        while(BookList.hasNext()){
            Book bookObj = (Book)BookList.next();
            System.out.println(bookObj.id + " - "+ bookObj.name + " - "+ bookObj.quantity);
        }
    }
}
