package DesignPatterns.BehavioralPatterns.MementoPattern.Two_Example;

import java.util.Stack;

public class NotificationHistory {
    private final Stack<NotificationMemento> history = new Stack<>();

    public void push(NotificationMemento memento) {
        history.push(memento);
    }

    public NotificationMemento pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
