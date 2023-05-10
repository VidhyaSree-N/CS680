package edu.umb.cs680.hw14;

import edu.umb.cs680.hw14.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseAlphabeticalTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void ReverseAlphabeticalSorting() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().get(0);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(y);
        expected.add(x);
        expected.add(test);
        expected.add(src);
        expected.add(lib);

        LinkedList< FSElement> actual =new LinkedList<>(root.getChildren((FSElement fs1, FSElement fs2)-> (fs2.getName().compareTo(fs1.getName()))));
        assertEquals(expected, actual);
    }

    @Test
    public void ReverseAlphabeticalSortingTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().get(0);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(y);
        expected.add(x);
        expected.add(test);
        expected.add(src);
        expected.add(lib);

        LinkedList<FSElement> actual = new LinkedList<>(root.getChildren(Comparator.comparing( FSElement::getName, Comparator.reverseOrder())));
        assertEquals(expected, actual);
    }

    @Test
    public void everseAlphabeticalSortingSubDirectories() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(test);
        expected.add(src);
        expected.add(lib);

        LinkedList< FSElement> actual =new LinkedList<>(root.getSubDirectories((FSElement fs1, FSElement fs2)-> (fs2.getName().compareTo(fs1.getName()))));
        assertEquals(expected, actual);
    }

    @Test
    public void ReverseAlphabeticalSortingFiles() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        File a = src.getFiles().get(0);
        File b = src.getFiles().get(1);

        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(b);
        expected.add(a);

        LinkedList<FSElement> actual = new LinkedList<>(src.getFiles(Comparator.comparing( FSElement::getName, Comparator.reverseOrder())));
        assertEquals(expected, actual);
    }

}
