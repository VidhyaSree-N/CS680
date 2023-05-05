package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.FSElement;

import java.util.Comparator;

public class TimeBased implements Comparator<FSElement> {
    @Override
    public int compare(FSElement fs1, FSElement fs2) {
        return fs1.getCreationTime().compareTo(fs2.getCreationTime());
    }
}
