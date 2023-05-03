package edu.umb.cs680.hw6;

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
        assertTrue(TestFixtureInitializer.root.isDirectory());
        assertFalse(TestFixtureInitializer.file_b.isDirectory());
    }

    @Test
    public void verifyEqualityFileA(){
        String[] expected = new String[]{"src","a","64",String.valueOf(TestFixtureInitializer.time)};
        File actual = TestFixtureInitializer.file_a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileB() {
        String[] expected = new String[]{"src","b","128",String.valueOf(TestFixtureInitializer.time)};
        File actual = TestFixtureInitializer.file_b;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileC(){
        String[] expected = new String[]{"lib","c","32",String.valueOf(TestFixtureInitializer.time)};
        File actual = TestFixtureInitializer.file_c;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileD(){
        String[] expected = new String[]{"src","d","1024",String.valueOf(TestFixtureInitializer.time)};
        File actual = TestFixtureInitializer.file_d;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileX(){
        String[] expected = new String[]{"root","x","0",String.valueOf(TestFixtureInitializer.time)};
        File actual = TestFixtureInitializer.file_x;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @AfterAll
    public static void print(){
        TestFixtureInitializer.tearDown();
        System.out.println("Test Cases Completed");
    }
}
