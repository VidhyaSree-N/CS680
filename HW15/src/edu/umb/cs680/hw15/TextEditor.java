package edu.umb.cs680.hw15;

public class TextEditor {
    private Editor editor;

    public TextEditor(Editor editor){
        this.editor = editor;
    }

    public String startEdit(String text){
        return editor.Editing(text);
    }
}
