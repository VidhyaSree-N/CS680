package edu.umb.cs680.hw7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    private String[] fileToStringArray(File file){
        String[] file_Info = {
                String.valueOf(file.getParent().getName()),
                file.getName(),
                String.valueOf(file.getSize()),
                String.valueOf(file.getCreationTime()),
        };
        return file_Info;
    }

    @Test
    public void isFileTest() {
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().getFirst();
        File b = src.getFiles().get(0);
        assertTrue(root.isDirectory());
        assertFalse(b.isDirectory());
    }

    @Test
    public void verifyEqualityFileA(){
        String[] expected = new String[]{"src","a","64",String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().getFirst();
        File actual = src.getFiles().getFirst();
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileB() {
        String[] expected = new String[]{"src","b","128",String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0).creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().getFirst();
        File actual = src.getFiles().get(1);
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileC(){
        String[] expected = new String[]{"lib","c","32",String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0).creationTime)};
        Directory root = fs.getRootDirs().get(0);
        Directory lib = root.getSubDirectories().get(1);
        File actual = lib.getFiles().getFirst();
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileD(){
        String[] expected = new String[]{"src","d","1024",String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0).creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().getFirst();
        File actual = srctest.getFiles().getFirst();
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileX(){
        String[] expected = new String[]{"root","x","0",String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).creationTime)};
        Directory root = fs.getRootDirs().getFirst();
        File actual = root.getFiles().getFirst();
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }
}
