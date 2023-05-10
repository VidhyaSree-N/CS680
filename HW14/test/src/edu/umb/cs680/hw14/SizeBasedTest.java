package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeBasedTest {
    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void SizeBasedSorting() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().get(0);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(src);
        expected.add(lib);
        expected.add(test);
        expected.add(x);
        expected.add(y);

        LinkedList<FSElement> actual = new LinkedList<>(root.getChildren((fs1, fs2) -> Integer.compare(fs1.getSize(), fs2.getSize())));
        assertEquals(expected, actual);
    }

    @Test
    public void SizeBasedWithComparator() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().get(0);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(src);
        expected.add(lib);
        expected.add(test);
        expected.add(x);
        expected.add(y);

        LinkedList<FSElement> actual = new LinkedList<>(root.getChildren(Comparator.comparing( FSElement::getSize)));
        assertEquals(expected, actual);
    }

    @Test
    public void SizeBasedSortingSubDirectories() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(src);
        expected.add(lib);
        expected.add(test);

        LinkedList<FSElement> actual = new LinkedList<>(root.getSubDirectories((fs1, fs2) -> Integer.compare(fs1.getSize(), fs2.getSize())));
        assertEquals(expected, actual);
    }

    @Test
    public void SizeBasedSortingFiles() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        File a = src.getFiles().get(0);
        File b = src.getFiles().get(1);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(a);
        expected.add(b);

        LinkedList<FSElement> actual = new LinkedList<>(src.getFiles(Comparator.comparing( FSElement::getSize)));
        assertEquals(expected, actual);
    }
}
