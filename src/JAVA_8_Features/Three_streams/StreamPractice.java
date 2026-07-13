package JAVA_8_Features.Three_streams;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String[] args) {
        System.out.println("--- Java 8 Stream API Practice ---");

        // Data for problems
        List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 75, 65);
        String input = "javaprogramming";
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
        List<Integer> numberStartWithOne = Arrays.asList(10, 15, 8, 49, 25, 98, 112);
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 75000),
                new Employee(2, "Bob", "IT", 85000),
                new Employee(3, "Charlie", "HR", 60000),
                new Employee(4, "David", "HR", 65000),
                new Employee(5, "Eve", "Finance", 90000),
                new Employee(6, "Frank", "IT", 65000)
        );
        List<String> words = Arrays.asList("apple", "banana", "watermelon", "kiwi", "strawberry");
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("A", "B", "C"),
                Arrays.asList("D", "E"),
                Arrays.asList("F", "G", "H")
        );

        // 1. Find the highest/second-highest number
        // findSecondHighest(numbers);
//        Question: Find the sum of all even numbers in a list of integers. numbers
//          SumOfEvenSum(numbers);
//
//        Question: You are given a list of strings representing names, like this:
//        performThreeActions();
//        The Task: Write a one-line Stream pipeline that does three things:
//        1. Converts all the names to uppercase.
//        2. Removes any duplicate names.
//        3. Collects the final result back into a List.


//        Question: Imagine you are working on a system where you have a list of Teams,
//        and each Team has a list of member names.
//        The Task: Write a one-line Stream pipeline that takes this nested structure
//        and produces a single,flat List<String> containing all the unique names,
//        sorted alphabetically.

        multipleListOfNames();

//        2. Count the frequency of characters in a String
        // countCharacterFrequency(input);

        // 3. Find duplicate elements in a List
        // findDuplicates(duplicateNumbers);
        
        // 4. Find the first non-repeated character in a String
        // findFirstNonRepeatedCharacter(input);
        
        // 5. Find numbers starting with '1'
        // findNumbersStartingWithOne(numberStartWithOne);

        // 6. Complex Grouping & Max By (Employee Scenarios)
        // highestPaidEmployeePerDepartment(employees);

        // 7. Find the longest string in a list
        // findLongestString(words);

        // 8. Flatten a list of lists using flatMap
        // flattenListOfLists(listOfLists);

        // 9. Partition elements into two groups based on a condition
        // partitionEmployeesBySalary(employees);
    }

//    private static void findSecondHighest(List<Integer> numbers) {
//        System.out.println("\n1. Second Highest Number in " + numbers);
//
//        Integer secondHighest = numbers.stream()
//                .distinct() // Remove duplicates like the two 50s
//                .sorted((a, b) -> b - a) // Sort in descending order
//                .skip(1) // Skip the first (highest) element
//                .findFirst() // Get the second one
//                .orElse(-1);
//
//        System.out.println("Result: " + secondHighest);
//    }

//    private static void SumOfEvenSum(List<Integer> numbers) {
//        int SumOfEvenNumbers = numbers.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
//        System.out.println("Sum of Even members list: " + SumOfEvenNumbers);
//    }

    //    private static void performThreeActions() {
//        List<String> NameList =  Arrays.asList("ATish", "BaGate", "ChetaN","EnginneR", "BaGate", "DOctor");
//        List<String> updatedNameList = NameList.stream().map(String::toLowerCase).distinct().sorted().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println("--- Perform three actions ---"+updatedNameList);
//    }
    private static void multipleListOfNames() {
        List<List<String>> teamOrders = Arrays.asList(
                Arrays.asList("Amit", "Neha"),
                Arrays.asList("Vikram", "Rahul", "Priya"),
                Arrays.asList("Amit", "Priya")
        );
        teamOrders.stream()
                .flatMap(team -> team.stream())
                .distinct()

                .forEach(System.out::println);
    }

    private static void countCharacterFrequency(String input) {
        System.out.println("\n2. Character frequency in string: '" + input + "'");

        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Result: " + frequencyMap);
    }

    private static void findDuplicates(List<Integer> numbers) {
        System.out.println("\n3. Find duplicate elements in " + numbers);

        // Group by element and count occurrences, then filter those with count > 1
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Result: " + duplicates);
    }
    
    private static void findFirstNonRepeatedCharacter(String input) {
        System.out.println("\n4. First non-repeated character in: '" + input + "'");
        
        // Use LinkedHashMap to preserve insertion order
        Character firstNonRepeated = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
                
        System.out.println("Result: " + firstNonRepeated);
    }
    
    private static void findNumbersStartingWithOne(List<Integer> numbers) {
        System.out.println("\n5. Numbers starting with '1' in " + numbers);
        
        List<String> startingWithOne = numbers.stream()
                .map(String::valueOf) // Convert integer to string
                .filter(s -> s.startsWith("1")) // Filter strings starting with '1'
                .collect(Collectors.toList());
                
        System.out.println("Result: " + startingWithOne);
    }
    
    private static void highestPaidEmployeePerDepartment(List<Employee> employees) {
        System.out.println("\n6. Highest Paid Employee in Each Department");
        
        Map<String, Optional<Employee>> highestPaid = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
                
        highestPaid.forEach((dept, emp) -> 
                System.out.println("Dept: " + dept + ", Employee: " + emp.map(Employee::getName).orElse("None"))
        );
    }

    private static void findLongestString(List<String> words) {
        System.out.println("\n7. Longest string in list: " + words);

        // Reduce compares elements and retains the longest
        String longest = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .orElse("");

        System.out.println("Result: " + longest);
    }

    private static void flattenListOfLists(List<List<String>> listOfLists) {
        System.out.println("\n8. Flatten list of lists: " + listOfLists);

        // flatMap transforms each inner list into a stream and flattens them into a single stream
        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("Result: " + flatList);
    }

    private static void partitionEmployeesBySalary(List<Employee> employees) {
        System.out.println("\n9. Partition employees by salary (> 70000)");

        // partitioningBy splits the data into exactly two groups (true and false)
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));

        System.out.println("Result:");
        System.out.println("  Highly Paid (> 70000): " + partitioned.get(true));
        System.out.println("  Others: " + partitioned.get(false));
    }
    
    // A typical Employee class used in Interview Questions
    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
        }
    }
}