package edu.umb.cs680.hw15;

public class Main {
    public static void main(String[] args) {

        String text = "Hello";
        TextEditor textEditor = new TextEditor(new TextUpperCase());
        textEditor.startEdit(text);
        textEditor = new TextEditor(new TextLowerCase());
        textEditor.startEdit(text);
        textEditor = new TextEditor(new CropText());
        textEditor.startEdit(text);
        textEditor = new TextEditor(new TextStyling());
        textEditor.startEdit(text);
        textEditor = new TextEditor(new AddText());
        textEditor.startEdit(text);
    }
}
