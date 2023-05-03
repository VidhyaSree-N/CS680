package edu.umb.cs680.hw8.fs.util;

import edu.umb.cs680.hw8.fs.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileCrawlingVisitorTest {
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
    private static Link link_y;

    private static SingletonFilesystem fs;

    private static class TestFixtureInitializer {
        public static SingletonFilesystem createFS() {
            SingletonFilesystem fs = SingletonFilesystem.getFileSystem();
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
            return fs;
        }

        public static void teardown(){
            time = null;
            root = null;
            src = null;
            lib = null;
            test = null;
            srctest = null;
            file_a = null;
            file_b = null;
            file_c = null;
            file_d = null;
            file_x = null;
        }
    }

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void testFilesInRoot(){
        LinkedList<File> expected = new LinkedList<File>();
        expected.add(file_a);
        expected.add(file_b);
        expected.add(file_c);
        expected.add(file_d);
        expected.add(file_x);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor fileCrawlingVisitor = new FileCrawlingVisitor();
        root.accept(fileCrawlingVisitor);
        LinkedList<File> actual = fileCrawlingVisitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInsrc(){
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(file_a);
        expected.add(file_b);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        src.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInLib(){
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(file_c);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        lib.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInSrcTest(){
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(file_d);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        srctest.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
        TestFixtureInitializer.teardown();
    }

}
