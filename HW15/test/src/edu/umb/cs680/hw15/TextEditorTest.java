package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {
    private String text;

    @Test
    public void AddTextTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor(new AddText());
        String actual = textEditor.startEdit(text);
        String expected = "Hello Additional text";
        assertEquals(expected,actual);
    }

    @Test
    public void TextUpperTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor(new TextUpperCase());
        String actual = textEditor.startEdit(text);
        String expected = "HELLO";
        assertEquals(expected,actual);
    }

    @Test
    public void TextLowerTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor(new TextLowerCase());
        String actual = textEditor.startEdit(text);
        String expected = "hello";
        assertEquals(expected,actual);
    }

    @Test
    public void TextStylingTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor(new TextStyling());
        String actual = textEditor.startEdit(text);
        String expected = "*#$ Hello $#*";
        assertEquals(expected,actual);
    }

    @Test
    public void CropTextTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor(new CropText());
        String actual = textEditor.startEdit(text);
        String expected = "He";
        assertEquals(expected,actual);
    }
}
