package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ElementBasedTest {
    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void ElementBasedTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        Directory lib = root.getSubDirectories().get(0);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().getFirst();
        Directory directory = root;
        FSElement[] expected = {lib,src,test,x,y};
        List<FSElement> actual = directory.getChildren(new ElementBased());
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void elementSubDirectoriesTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().get(0);
        File d = srctest.getFiles().getFirst();

        FSElement[] expected = {srctest};
        LinkedList<Directory> actual = test.getSubDirectories(new ElementBased());
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void ElementFilesTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        File a = src.getFiles().getFirst();
        File b = src.getFiles().get(1);

        FSElement[] expected = {a,b};
        LinkedList<File> rat = src.getFiles(new ElementBased());
        assertArrayEquals(expected,rat.toArray());
    }
}
