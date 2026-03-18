package DesignPatterns.BehavioralPatterns.MementoPattern.One_Example;

// this is the editor class content real text of the editor.
public class TextEditor {
    private String text;

    public void write(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    //    this function will give in return editor memento
    public EditorMemento save() {
        return new EditorMemento(text);
    }

    // this will restore to content by memento
    public void restore(EditorMemento memento) {
        this.text = memento.getText();
    }

}
