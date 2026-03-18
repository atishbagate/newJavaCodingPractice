package DesignPatterns.BehavioralPatterns.MementoPattern.One_Example;

// this class manages state of editor.

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class editorManager {
    private final Stack<EditorMemento> history = new Stack<EditorMemento>();

    public void saveState(@NotNull TextEditor textEditor) {
        history.push(textEditor.save());
    }

    public void undo(@NotNull TextEditor textEditor) {
        history.pop();
        if (history.isEmpty()) {
            return;
        }
        textEditor.restore(history.peek());
    }
}
