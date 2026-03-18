package DesignPatterns.BehavioralPatterns.MementoPattern.One_Example;

public class MementoMain {
    public static void main(String[] args) {
//        This is main Memento pattern
        TextEditor editor = new TextEditor();
        editorManager editorManager = new editorManager(); // manages history
        editor.write("A");
        editorManager.saveState(editor);
        editor.write("B");
        editorManager.saveState(editor);
        System.out.println(editor.getText());
        editorManager.undo(editor);
        editorManager.undo(editor);
        System.out.println(editor.getText());

    }
}
