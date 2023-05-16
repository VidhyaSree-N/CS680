package edu.umb.cs680.hw15;

public class TextStyling implements Editor {
    @Override
    public String Editing(String text) {
        String textStyle = "*#$ " + text + " $#*";
        System.out.println("Text styled to: " + textStyle);
        return textStyle;
    }
}
