package Collections.HashMapExamples;

import java.util.HashMap;
import java.util.Map;

public class EmployeeHashMap {
   static class Employee {
        int id;
        String name;
        String department;

       public Employee( int id,String name,String department) {
           this.department = department;
           this.id = id;
           this.name = name;
       }

       @Override
        public String toString() {
            return "Employee{" +
                    "department='" + department + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }


    }

    public static void main(String[] args) {
        System.out.println("Employee using hash map");
        // Creating a HashMap to store employees with their ID as the key
        HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

        employeeMap.put(101,new Employee(101,"Atish","IT"));
        employeeMap.put(102,new Employee(102,"Sumit","HR"));
        employeeMap.put(103,new Employee(103,"vaibhav","mech"));

//        System.out.println(employeeMap);
//        System.out.println(employeeMap.get(101));

//        check if key exists
//         int searchId = 104;
//         if(!employeeMap.containsKey(searchId)) {
//             System.out.println("Employee with Id "+searchId+" not found");
//         }

//         iterating over map
        System.out.println("Employee list ");
         for (Map.Entry<Integer,Employee> entry : employeeMap.entrySet()){
             int empId = entry.getKey();
             Employee empDept = entry.getValue();
             System.out.println("id "+empId +" - " + empDept);
         }

//         updating a values
        Employee atish = employeeMap.get(101);
         atish.department = "Comp";
        System.out.println("101 emp no : "+employeeMap.get(101));

        employeeMap.remove(103);

        System.out.println(employeeMap);

    }
}
