package edu.umb.cs680.hw7;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void isDirectory() {
        assertTrue(fs.getRootDirs().get(0).isDirectory());
        Directory root = fs.getRootDirs().getFirst();
        assertFalse(root.getLinks().get(0).isDirectory());
    }

    @Test
    public void isLink() {
        Directory root = fs.getRootDirs().getFirst();
        Link y = root.getLinks().get(0);
        File x = root.getFiles().getFirst();
        assertTrue(y.isLink());
        assertFalse(x.isLink());
        assertFalse(root.isLink());
    }

    @Test
    public void getTargetTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Link y = root.getLinks().get(0);
        Directory srctest = test.getSubDirectories().getFirst();
        assertEquals(srctest, y.getTarget());
    }

    @Test
    public void setTargetTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Link y = root.getLinks().get(0);
        y.setTarget(test);
        assertEquals(test, y.getTarget());
    }

    @AfterAll
    public static void print() {
        System.out.println("Test Cases Completed");
    }
}
