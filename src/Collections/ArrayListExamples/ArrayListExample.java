package Collections.ArrayListExamples;

import java.util.ArrayList;

public class ArrayListExample {
    public ArrayListExample(){

        System.out.println("This is the ArrayList Example.");
//        new Arraylist
       ArrayList<String> listStr = new ArrayList<String>();
//        adding
        listStr.add("mango");
        listStr.add("apple");
        listStr.add("orange");
        listStr.add("banana");
//        System.out.println(listStr);
//        using iterator
//    Iterator itr = listStr.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }
//        using for loop
//        for(String fruit:listStr){
//            System.out.println(fruit);
//        }
//        getter & setter
//        System.out.println("Getting value at index : 1"+ listStr.get(1));
//        listStr.set(1,"papaya");
//      Iterator<String> itr = listStr.iterator();
//      while (itr.hasNext()){
//          System.out.println(itr.next());
//      }
//        Collections.sort(listStr);
//       Iterator<String> itr = listStr.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }


//        System.out.println("User-defined class objects in Java ArrayList");
//        Student s1 = new Student(1,"Ram",24);
//        Student s2 = new Student(2,"shyam",25);
//        Student s3 = new Student(3,"mahesh",26);
//
//        ArrayList<Student> studentArrList = new ArrayList<Student>();
//
//        studentArrList.add(s1);
//        studentArrList.add(s2);
//        studentArrList.add(s3);
//
//       Iterator studentIterator = studentArrList.iterator();
//
//       while (studentIterator.hasNext()){
//           Student std = (Student)studentIterator.next();
//           System.out.println(std.rollNo + " - "+ std.name + " - "+ std.age);
//       }

       //adding elements

        listStr.add("Pineapple");

//        Iterator itr = listStr.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }

//        adding another List to old List

//       ArrayList<String>  newItr = new ArrayList<String>();
//        newItr.add("watermelon");
//        newItr.add("guava");
//        listStr.addAll(newItr);
//        Iterator itr = listStr.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }
//        adding List at specifitc Place
//         listStr.addAll(1,newItr);
//        Iterator itr = listStr.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }


        //remove Example
//        remove specific element
//        listStr.remove(1);
//        System.out.println(listStr);

//        remove all new added List
//       ArrayList<String>  newItr = new ArrayList<String>();
//        newItr.add("watermelon");
//        newItr.add("guava");
//
//        listStr.addAll(newItr);
//        System.out.println(listStr);
//        listStr.removeAll(newItr);
//        System.out.println(listStr);

//        remove element on the basis of condition
//        System.out.println("Before - " +listStr);
//        listStr.removeIf(item -> item.contains("banana"));
//        System.out.println("After - " + listStr);

//        remove all
//        listStr.clear();
//        System.out.println("All removed - "+ listStr);

        System.out.println("is Empty : "+ listStr.isEmpty());
        System.out.println("Size of : "+ listStr.size());
    }

}
