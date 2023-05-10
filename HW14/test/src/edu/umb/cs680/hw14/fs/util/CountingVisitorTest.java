package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.SingletonFilesystem;
import edu.umb.cs680.hw14.fs.TestFixtureInitializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingVisitorTest {
    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }


    @Test
    public void testRootDirectoriesCount() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().accept(countingVisitor);
        assertEquals(5,countingVisitor.getDirNum());
    }

    @Test
    public void testLinksForRoot() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().accept(countingVisitor);
        assertEquals(1,countingVisitor.getLinkNum());
    }

    @Test
    public void testLinksForTest() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().getSubDirectories().get(2).accept(countingVisitor);
        assertEquals(0,countingVisitor.getLinkNum());
    }
    @Test
    public void testFilesForSrc() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().getSubDirectories().get(1).accept(countingVisitor);
        assertEquals(2,countingVisitor.getFileNum());
    }

    @Test
    public void testFilesForSrcTest() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().getSubDirectories().get(2).getSubDirectories().get(0).accept(countingVisitor);
        assertEquals(1,countingVisitor.getFileNum());
    }

    @Test
    public void testLibFilesCount() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().getSubDirectories().get(0).accept(countingVisitor);
        assertEquals(1,countingVisitor.getFileNum());
    }
    @Test
    public void testDirectoriesForTest() {
        CountingVisitor countingVisitor = new CountingVisitor();
        fs.getRootDirs().getFirst().getSubDirectories().get(2).accept(countingVisitor);
        assertEquals(2,countingVisitor.getDirNum());
    }
    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }

}
