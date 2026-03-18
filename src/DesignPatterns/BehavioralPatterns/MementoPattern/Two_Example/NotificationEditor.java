package DesignPatterns.BehavioralPatterns.MementoPattern.Two_Example;

public class NotificationEditor {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationMemento save() {
        return new NotificationMemento(content);
    }

    public void restore(NotificationMemento memento) {
        if (memento != null) {
            this.content = memento.getContent();
        }
    }
}
