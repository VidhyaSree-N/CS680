package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.SingletonFilesystem;
import edu.umb.cs680.hw12.fs.TestFixtureInitializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class FileSearchVisitorTest {
    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void testSize(){
        Directory root = fs.getRootDirs().getFirst();

        FileSearchVisitor visitor = new FileSearchVisitor("b");
        root.accept(visitor);
        assertSame(1,visitor.getFoundFiles().size());
    }

    @Test
    public void testFileInRoot(){
        Directory root = fs.getRootDirs().getFirst();
        Directory test = root.getSubDirectories().get(2);
        Directory srctest = test.getSubDirectories().get(0);
        File d = srctest.getFiles().getFirst();
        FileSearchVisitor visitor = new FileSearchVisitor("d");
        root.accept(visitor);
        LinkedList<File> actual = visitor.getFoundFiles();
        assertEquals(d,actual.get(0));
    }

    @Test
    public void testFileInLib(){
        Directory root = fs.getRootDirs().getFirst();
        Directory lib = root.getSubDirectories().get(0);
        File c = lib.getFiles().get(0);


        FileSearchVisitor visitor = new FileSearchVisitor("c");
        lib.accept(visitor);
        LinkedList<File> actual = visitor.getFoundFiles();
        assertEquals(c,actual.get(0));
    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }

}
