package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TimeBasedTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void timeBasedTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().getFirst();
        Directory src = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        File x = root.getFiles().get(0);
        Link y = root.getLinks().getFirst();

        Directory directory = root;
        FSElement[] expected = {src,lib,test,x,y};
        List<FSElement> actual = directory.getChildren(new TimeBased());
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void TimeSubDirectoriesTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().get(0);

        FSElement[] expected = {srctest};
        LinkedList<Directory> actual = test.getSubDirectories(new TimeBased());
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void TimeFilesTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);
        File a = src.getFiles().getFirst();
        File b = src.getFiles().get(1);

        Directory directory = src;
        FSElement[] expected = {a,b};
        LinkedList<File> actual = directory.getFiles(new TimeBased());
        assertArrayEquals(expected,actual.toArray());
    }

}

