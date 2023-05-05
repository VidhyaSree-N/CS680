package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.FSElement;

import java.util.Comparator;

public class ElementBased implements Comparator<FSElement> {

    //Diectories followed by files and links
    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        if (fs1.isDirectory() && !fs2.isDirectory()) {
            return -1;
        } else if (!fs1.isDirectory() && fs2.isDirectory()) {
            return 1;
        } else {
            return fs1.getName().compareTo(fs2.getName());
        }
    }

}
