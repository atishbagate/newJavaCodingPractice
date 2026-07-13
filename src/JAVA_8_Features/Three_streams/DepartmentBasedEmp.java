package JAVA_8_Features.Three_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(String name, int id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}


public class DepartmentBasedEmp {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Atish", 1, "IT", 200),
                new Employee("Sumit", 2, "Student", 600),
                new Employee("vaibhav", 3, "Study", 400),
                new Employee("ram", 4, "IT", 800)
        );

// Q : given a list of emp, group them by dept and return a Map<String,Long>
// where the key is the department name and the value is the number of emp in that dept.
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((k, v) -> {
                    System.out.println(k + "  " + v);
                });


        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
