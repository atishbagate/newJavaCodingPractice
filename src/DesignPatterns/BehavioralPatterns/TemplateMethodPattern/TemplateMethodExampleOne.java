package DesignPatterns.BehavioralPatterns.TemplateMethodPattern;

/**
 * TEMPLATE METHOD PATTERN
 * <p>
 * Intent:
 * Template Method is a behavioral design pattern that defines the skeleton of an algorithm
 * in the superclass but lets subclasses override specific steps of the algorithm without
 * changing its structure.
 * <p>
 * Problem it solves:
 * You have multiple classes that perform similar tasks with slight variations in some steps.
 * Instead of duplicating the entire algorithm, you can create a common template and allow
 * subclasses to implement the varying parts.
 * <p>
 * How it works:
 * - Abstract Class: Declares the template method containing the skeleton of the algorithm.
 * It may also contain abstract methods (must be implemented by subclasses) and "hooks"
 * (optional methods with default implementations). (e.g., DataMiner)
 * - Concrete Classes: Implement the abstract steps and optionally override the hooks.
 * They cannot override the template method itself (usually marked as final).
 * (e.g., CSVExtract, ExcelExtract)
 * <p>
 * Benefits:
 * - Code Reuse: You can pull the duplicate code into a superclass.
 * - Inversion of Control: The superclass calls the methods of subclasses, not the other way around
 * (the "Hollywood Principle": "Don't call us, we'll call you").
 * - Flexibility: Clients can easily override only certain parts of a large algorithm.
 */
abstract class DataMiner {
    // This is the Template Method. It is final so subclasses cannot override it.
    public final void processData() {
        readData();
        parseData();
        analyseData();
        exportReport();
    }

    private void readData() {
        System.out.println("reading data");
    }

    // Abstract methods: Must be implemented by subclasses
    protected abstract void analyseData();

    protected abstract void parseData();

    // Hook: Can be optionally overridden by subclasses
    protected void exportReport() {
        System.out.println("exporting report");
    }
}

class CSVExtract extends DataMiner {

    @Override
    protected void analyseData() {
        System.out.println("parsing rows from CSV.");
    }

    @Override
    protected void parseData() {
        System.out.println("parsing CSV data");
    }
}

class ExcelExtract extends DataMiner {

    @Override
    protected void analyseData() {
        System.out.println("Excel extraction");
    }

    @Override
    protected void parseData() {
        System.out.println("parse Data From Excel");
    }

    @Override
    protected void exportReport() {
        System.out.println("excel data exported.");
    }
}

public class TemplateMethodExampleOne {
    public static void main(String[] args) {
        System.out.println("--- CSV Extraction ---");
        DataMiner csvMiner = new CSVExtract();
        csvMiner.processData();

        System.out.println("\n--- Excel Extraction ---");
        DataMiner excelMiner = new ExcelExtract();
        excelMiner.processData();
    }
}
