package edu.umb.cs680.hw6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){
        String parent = null;
        // created if condition because of null point exception for testing root
        if(d.getParent() != null){
            parent = String.valueOf(d.getParent().getName());
        }
        String[] dirInfo = {
                parent,
                d.getName(),
                String.valueOf(d.getSize()),
                String.valueOf(d.getCreationTime()),
        };
        return dirInfo;
    }

    @Test
    public void isDirectory() {
        assertTrue(TestFixtureInitializer.root.isDirectory());
        assertFalse(TestFixtureInitializer.file_a.isDirectory());
    }

    @Test
    public void getChildrenTest() {
        assertEquals(2, TestFixtureInitializer.src.getChildren().size());
    }

    @Test
    public void appendChildTest() {
        assertEquals(1, TestFixtureInitializer.lib.getChildren().size());
    }

    @Test
    public void countChildrenTest() {
        assertEquals(4, TestFixtureInitializer.root.countChildren());
    }

    @Test
    public void getSubDirectoriesTest() {
        assertEquals(3, TestFixtureInitializer.root.getSubDirectories().size());
    }

    @Test
    public void getFilesTest() {
        assertEquals(1, TestFixtureInitializer.lib.getFiles().size());
    }

    @Test
    public void getTotalSize() {
        assertEquals(1024, TestFixtureInitializer.test.getTotalSize());
    }

    @Test
    public void verifyEqualityDirectoryRoot(){
        String[] expected = new String[]{null,"root", "0",String.valueOf(TestFixtureInitializer.time)};
        Directory actual = TestFixtureInitializer.root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorysrc () {
        String[] expected = new String[]{"root","src","0",String.valueOf(TestFixtureInitializer.time)};
        Directory actual = TestFixtureInitializer.src;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorylib (){
        String[] expected = new String[]{"root","lib","0",String.valueOf(TestFixtureInitializer.time)};
        Directory actual = TestFixtureInitializer.lib;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorytest (){
        String[] expected = new String[]{"root","test","0",String.valueOf(TestFixtureInitializer.time)};
        Directory actual = TestFixtureInitializer.test;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorysrctest (){
        String[] expected = new String[]{"test","src","0",String.valueOf(TestFixtureInitializer.time)};
        Directory actual = TestFixtureInitializer.srctest;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @AfterAll
    public static void print(){
        TestFixtureInitializer.tearDown();
        System.out.println("Test Cases Completed");
    }
}
