package edu.umb.cs680.hw15;

public class CropText implements Editor{
    @Override
    public String Editing(String text) {
        String cropText = text.substring(0, text.length() / 2);
        System.out.println("Text cropped to: " + cropText);
        return cropText;
    }
}
