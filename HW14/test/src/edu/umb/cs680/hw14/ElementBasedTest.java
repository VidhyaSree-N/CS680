package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementBasedTest {
    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void ElementBasedSorting() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().get(0);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(lib);
        expected.add(src);
        expected.add(test);
        expected.add(x);
        expected.add(y);

        LinkedList< FSElement> actual =new LinkedList<>(root.getChildren((FSElement fs1, FSElement fs2) -> {
            if (fs1.isDirectory() && !fs2.isDirectory()) {
                return -1;
            } else if (!fs1.isDirectory() && fs2.isDirectory()) {
                return 1;
            } else {
                return fs1.getName().compareTo(fs2.getName());
            }
        }));
        assertEquals(expected, actual);
    }

    @Test
    public void ElementBasedSortingSubDirectories() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(lib);
        expected.add(src);
        expected.add(test);

        LinkedList< FSElement> actual =new LinkedList<>(root.getSubDirectories((FSElement fs1, FSElement fs2) -> {
            if (fs1.isDirectory() && !fs2.isDirectory()) {
                return -1;
            } else if (!fs1.isDirectory() && fs2.isDirectory()) {
                return 1;
            } else {
                return fs1.getName().compareTo(fs2.getName());
            }
        }));
        assertEquals(expected, actual);
    }

    @Test
    public void ElementBasedSortingFiles() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        File a = src.getFiles().get(0);
        File b = src.getFiles().get(1);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);

        LinkedList<FSElement> actual = new LinkedList<>(src.getFiles((FSElement fs1, FSElement fs2) -> {
            if (fs1.isDirectory() && !fs2.isDirectory()) {
                return -1;
            } else if (!fs1.isDirectory() && fs2.isDirectory()) {
                return 1;
            } else {
                return fs1.getName().compareTo(fs2.getName());
            }
        }));
        assertEquals(expected, actual);
    }
}
