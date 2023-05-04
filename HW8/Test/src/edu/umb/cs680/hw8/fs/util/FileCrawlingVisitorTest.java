package edu.umb.cs680.hw8.fs.util;

import edu.umb.cs680.hw8.fs.Directory;
import edu.umb.cs680.hw8.fs.File;
import edu.umb.cs680.hw8.fs.SingletonFilesystem;
import edu.umb.cs680.hw8.fs.TestFixtureInitializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileCrawlingVisitorTest {
    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void testFilesInRoot(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().getFirst();
        Directory lib = root.getSubDirectories().get(1);
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().get(0);
        File a = src.getFiles().getFirst();
        File b = src.getFiles().get(1);
        File c = lib.getFiles().get(0);
        File d = srctest.getFiles().getFirst();
        File x = root.getFiles().get(0);

        LinkedList<File> expected = new LinkedList<File>();
        expected.add(a);
        expected.add(b);
        expected.add(c);
        expected.add(d);
        expected.add(x);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor fileCrawlingVisitor = new FileCrawlingVisitor();
        root.accept(fileCrawlingVisitor);
        LinkedList<File> actual = fileCrawlingVisitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInsrc(){
        Directory root = fs.getRootDirs().getFirst();
        Directory src = root.getSubDirectories().getFirst();
        File a = src.getFiles().getFirst();
        File b = src.getFiles().get(1);

        LinkedList<File> expected = new LinkedList<File>();

        expected.add(a);
        expected.add(b);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        src.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInLib(){
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(1);
        File c = lib.getFiles().get(0);

        LinkedList<File> expected = new LinkedList<File>();

        expected.add(c);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        lib.accept(visitor);
        LinkedList<File> actual = visitor.getFiles();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInSrcTest(){
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().get(0);
        File d = srctest.getFiles().getFirst();


        LinkedList<File> expected = new LinkedList<File>();

        expected.add(d);

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
    }

}
