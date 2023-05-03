package edu.umb.cs680.hw8.fs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    private static LocalDateTime time;
    private static Directory root;
    private static Directory src;
    private static Directory lib;
    private static Directory test;
    private static Directory srctest;
    private static File file_a;
    private static File file_b;
    private static File file_c;
    private static File file_d;
    private static File file_x;

    @BeforeAll
    public static void createFS() {
        time = LocalDateTime.now();
        root = new Directory(null, "root", 0, time);
        src = new Directory(root, "src", 0, time);
        lib = new Directory(root, "lib", 0, time);
        test = new Directory(root, "test", 0, time);
        srctest = new Directory(test, "src", 0, time);
        file_a = new File(src, "a", 64, time);
        file_b = new File(src, "b", 128, time);
        file_c = new File(lib, "c", 32, time);
        file_d = new File(srctest, "d", 1024, time);
        file_x = new File(root, "x", 0, time);

        //directories
        root.appendChild(src);
        root.appendChild(lib);
        root.appendChild(test);
        test.appendChild(srctest);
        //files
        src.appendChild(file_a);
        src.appendChild(file_b);
        lib.appendChild(file_c);
        srctest.appendChild(file_d);
        root.appendChild(file_x);
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
        assertTrue(root.isDirectory());
        assertFalse(file_b.isDirectory());
    }

    @Test
    public void verifyEqualityFileA(){
        String[] expected = new String[]{"src","a","64",String.valueOf(time)};
        File actual = file_a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileB() {
        String[] expected = new String[]{"src","b","128",String.valueOf(time)};
        File actual = file_b;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileC(){
        String[] expected = new String[]{"lib","c","32",String.valueOf(time)};
        File actual = file_c;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileD(){
        String[] expected = new String[]{"src","d","1024",String.valueOf(time)};
        File actual = file_d;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyEqualityFileX(){
        String[] expected = new String[]{"root","x","0",String.valueOf(time)};
        File actual = file_x;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }

}
