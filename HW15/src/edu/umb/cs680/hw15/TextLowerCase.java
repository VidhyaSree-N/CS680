package edu.umb.cs680.hw15;

public class TextLowerCase implements Editor {
    @Override
    public String Editing(String text) {
        String sizeLower = text.toLowerCase();
        System.out.println("Text sized to:-" + " LowerCase : " + sizeLower);
        return sizeLower;
    }
}
