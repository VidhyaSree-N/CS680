package edu.umb.cs680.hw8.fs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {
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

    @BeforeEach
    public void createFS() {
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
    public void isDirectoryTest() {
        assertTrue(root.isDirectory());
        assertFalse(file_a.isDirectory());
    }

    @Test
    public void getChildrenTest() {
        assertEquals(2, src.getChildren().size());
    }

    @Test
    public void appendChildTest() {
        assertEquals(1, lib.getChildren().size());
    }

    @Test
    public void countChildrenTest() {
        assertEquals(4, root.countChildren());
    }

    @Test
    public void getSubDirectoriesTest() {
        assertEquals(3, root.getSubDirectories().size());
    }

    @Test
    public void getFilesTest() {
        assertEquals(1, lib.getFiles().size());
    }

    @Test
    public void getTotalSize() {
        assertEquals(1024, test.getTotalSize());
    }

    @Test
    public void verifyEqualityDirectoryRoot(){
        String[] expected = new String[]{null,"root", "0",String.valueOf(time)};
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorysrc () {
        String[] expected = new String[]{"root","src","0",String.valueOf(time)};
        Directory actual = src;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorylib (){
        String[] expected = new String[]{"root","lib","0",String.valueOf(time)};
        Directory actual = lib;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorytest (){
        String[] expected = new String[]{"root","test","0",String.valueOf(time)};
        Directory actual = test;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityDirectorysrctest (){
        String[] expected = new String[]{"test","src","0",String.valueOf(time)};
        Directory actual = srctest;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
}
