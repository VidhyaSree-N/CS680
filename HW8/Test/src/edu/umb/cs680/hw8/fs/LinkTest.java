package edu.umb.cs680.hw8.fs;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {

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
    //Creating link
    private static Link link_y;

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
        //Creating link
        link_y = new Link(root,"y",0,time,srctest);

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
        root.appendChild(link_y);
    }

    @Test
    public void isDirectory() {
        assertTrue(root.isDirectory());
        assertFalse(link_y.isDirectory());
    }

    @Test
    public void isLink() {
        assertTrue(link_y.isLink());
        assertFalse(file_b.isLink());
        assertFalse(root.isLink());

    }

    @Test
    public void getTargetTest() {
        assertEquals(srctest, link_y.getTarget());
    }

    @Test
    public void setTargetTest() {
        link_y.setTarget(test);
        assertEquals(test, link_y.getTarget());
    }
}
