package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestwithLE {
    private String text;

    @Test
    public void AddTextTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor((String t) -> {
            String addedText = t + " Additional text";
            return addedText;
        });
        String actual = textEditor.startEdit(text);
        String expected = "Hello Additional text";
        assertEquals(expected,actual);
    }

    @Test
    public void TextUpperTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor((String t) -> {
            String sizeLower = text.toUpperCase();
            return sizeLower;
        });
        String actual = textEditor.startEdit(text);
        String expected = "HELLO";
        assertEquals(expected,actual);
    }

    @Test
    public void TextLowerTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor((String t) -> {
            String sizeLower = text.toLowerCase();
            return sizeLower;
        });
        String actual = textEditor.startEdit(text);
        String expected = "hello";
        assertEquals(expected,actual);
    }

    @Test
    public void TextStylingTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor((String t) -> {
            String textStyle = "*#$ " + text + " $#*";
            return textStyle;
        });
        String actual = textEditor.startEdit(text);
        String expected = "*#$ Hello $#*";
        assertEquals(expected,actual);
    }

    @Test
    public void CropTextTest(){
        text = "Hello";
        TextEditor textEditor = new TextEditor((String t) -> {
            String cropText = t.substring(0, t.length() / 2);
            return cropText;
        });
        String actual = textEditor.startEdit(text);
        String expected = "He";
        assertEquals(expected,actual);
    }
}
