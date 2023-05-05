package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseAlphabeticalTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void reverseAlphabeticalTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        Directory lib = root.getSubDirectories().get(0);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().getFirst();
        Directory directory = root;
        FSElement[] expected = {y,x,test,src,lib};
        List<FSElement> actual = directory.getChildren(new ReverseAlphabetical());
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void reverseAlphabeticalSubDirectoriesTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().get(0);
        File d = srctest.getFiles().getFirst();

        FSElement[] expected = {srctest};
        LinkedList<Directory> actual = test.getSubDirectories(new ReverseAlphabetical());
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void reverseAlphabeticalFilesTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        File a = src.getFiles().getFirst();
        File b = src.getFiles().get(1);

        FSElement[] expected = {b,a};
        LinkedList<File> rat = src.getFiles(new ReverseAlphabetical());
        assertArrayEquals(expected,rat.toArray());
    }

}


