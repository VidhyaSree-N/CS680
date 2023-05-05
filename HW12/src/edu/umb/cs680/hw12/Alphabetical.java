package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.FSElement;

import java.util.Comparator;

public class Alphabetical implements Comparator<FSElement> {

    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        return fs1.getName().compareTo(fs2.getName());
    }

}