package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.FSElement;

import java.util.Comparator;

public class SizeBased implements Comparator<FSElement> {

    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        Integer size1 = fs1.getSize();
        Integer size2 = fs2.getSize();
        return size1.compareTo(size2);
    }

}