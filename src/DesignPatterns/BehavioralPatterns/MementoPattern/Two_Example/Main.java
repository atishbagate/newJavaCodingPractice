package DesignPatterns.BehavioralPatterns.MementoPattern.Two_Example;

public class Main {
    public static void main(String[] args) {
        NotificationEditor editor = new NotificationEditor();
        NotificationHistory history = new NotificationHistory();

        System.out.println("Drafting notification...");
        editor.setContent("Your order has been placed.");
        System.out.println("Notification Content: " + editor.getContent());
        history.push(editor.save());

        editor.setContent("Your order has been shipped.");
        System.out.println("Notification Content: " + editor.getContent());
        history.push(editor.save());

        editor.setContent("Your order has been delivered.");
        System.out.println("Notification Content: " + editor.getContent());

        System.out.println("\nUndoing last change...");
        editor.restore(history.pop());
        System.out.println("Restored Content: " + editor.getContent());

        System.out.println("\nUndoing another change...");
        editor.restore(history.pop());
        System.out.println("Restored Content: " + editor.getContent());
    }
}
