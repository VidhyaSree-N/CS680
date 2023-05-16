package edu.umb.cs680.hw15;

public class TextUpperCase implements Editor{
    @Override
    public String Editing(String text) {
        String sizeUpper = text.toUpperCase();
        System.out.println("Text sized to:- " + "UpperCase : " + sizeUpper);
        return sizeUpper;
    }
}
