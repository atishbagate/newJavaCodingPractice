package Collections.List.ArrayListExamples;

public class Student {
    int rollNo;
    String name;
    int age;

    Student(int rollNo,String name, int age){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    void DisplayInfo() {
        System.out.println("student details  : " + this.rollNo + " : " + this.name + " : " + this.age + " : " + this.name);
    }
}

