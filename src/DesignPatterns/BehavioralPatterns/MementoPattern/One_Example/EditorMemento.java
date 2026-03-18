package DesignPatterns.BehavioralPatterns.MementoPattern.One_Example;

//  momento class : this class is the internal state of text editor.
public class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getText() {
        return content;
    }
}
