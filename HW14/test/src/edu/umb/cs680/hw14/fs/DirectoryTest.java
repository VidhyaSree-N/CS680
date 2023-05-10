package edu.umb.cs680.hw14.fs;

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
        assertTrue(fs.getRootDirs().getFirst().isDirectory());
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().getFirst();
        File a = src.getFiles().getFirst();
        assertFalse(a.isDirectory());
    }

    @Test
    public void getChildrenTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().get(1);

        assertEquals(2,src.getChildren().size());
    }

    @Test
    public void appendChildTest() {
        Directory root = fs.getRootDirs().get(0);
        Directory lib = root.getSubDirectories().get(0);

        assertEquals(1, lib.getChildren().size());
    }

    @Test
    public void countChildrenTest() {
        Directory root = fs.getRootDirs().getFirst();
        assertEquals(5, root.countChildren());
    }

    @Test
    public void getSubDirectoriesTest() {
        Directory root = fs.getRootDirs().getFirst();
        assertEquals(0, root.getSubDirectories().get(2).size);
    }

    @Test
    public void getFilesTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        assertEquals(32, lib.getFiles().get(0).size);
    }

    @Test
    public void getTotalSize() {
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        assertEquals(1024, test.getTotalSize());
    }

    @Test
    public void verifyEqualityDirectoryRoot(){
        String[] expected = new String[]{null,"root", "0",String.valueOf(fs.getRootDirs().getFirst().creationTime)};
        Directory actual = fs.getRootDirs().getFirst();
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorysrc () {
        String[] expected = new String[]{"root","src","0",String.valueOf(fs.getRootDirs().getFirst().getSubDirectories().getFirst().creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        Directory actual = root.getSubDirectories().get(1);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorylib (){
        String[] expected = new String[]{"root","lib","0",String.valueOf(fs.getRootDirs().getFirst().getSubDirectories().get(1).creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        Directory actual = root.getSubDirectories().get(0);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorytest (){
        String[] expected = new String[]{"root","test","0",String.valueOf(fs.getRootDirs().getFirst().getSubDirectories().get(2).creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        Directory actual = root.getSubDirectories().get(2);
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorysrctest (){
        String[] expected = new String[]{"test","src","0",String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(2).creationTime)};
        Directory test = fs.getRootDirs().getFirst().getSubDirectories().get(2);
        Directory actual = test.getSubDirectories().getFirst();
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }
}
