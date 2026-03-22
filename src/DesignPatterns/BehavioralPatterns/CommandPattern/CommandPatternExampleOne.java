package DesignPatterns.BehavioralPatterns.CommandPattern;

//The Command Pattern is like a waiter in a restaurant. You (the Client) give an order (the Command) to the waiter (the Invoker).
// The waiter doesn't need to know how to cook the steak; they just carry the order to the Chef (the Receiver) who knows the specific logic.
//Features of the Command Pattern
//Encapsulation: It wraps a request as a standalone object containing all information about the request.
//Decoupling: The object that triggers the command (Invoker) is completely separated from the object that executes the logic (Receiver).
//Uniform Interface: All commands usually implement the same interface (e.g., an execute() method).
//Queueing & Logging: Commands can be stored in a list to be executed later, scheduled, or logged for history

interface Command {
    void execute();
}

class BoldCommand implements Command {
    private TextEditor textEditor;

    public BoldCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.boldText();
    }
}

class StrikethroughCommand implements Command {
    private TextEditor textEditor;

    public StrikethroughCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.underlineText();
    }
}

class Button {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

class TextEditor {
    public void boldText() {
        System.out.println("text is bold.");
    }

    public void underlineText() {
        System.out.println("text is underlined.");
    }
}

public class CommandPatternExampleOne {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        Button button = new Button();

        button.setCommand(new BoldCommand(textEditor));
//        button.setCommand( new StrikethroughCommand(textEditorxtEditor));
        button.click();
    }
}
