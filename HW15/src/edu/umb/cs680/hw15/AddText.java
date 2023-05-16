package edu.umb.cs680.hw15;

public class AddText implements Editor{
    @Override
    public String Editing(String text) {
        String AddedText = text + " Additional text";
        System.out.println(AddedText );
        return AddedText;
    }
}
