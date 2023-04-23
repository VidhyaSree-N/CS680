package edu.umb.cs680.hw8.fs.util;

import edu.umb.cs680.hw8.fs.Directory;
import edu.umb.cs680.hw8.fs.File;
import edu.umb.cs680.hw8.fs.Link;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CountingVisitorTest {

    public static LocalDateTime time = LocalDateTime.now();
    static Directory root = new Directory(null,"root", 0, time);
    static Directory src = new Directory(root,"src", 0, time);
    static Directory lib = new Directory(root,"lib", 0, time);
    static Directory test = new Directory(root,"test", 0, time);
    static Directory srctest = new Directory(test,"src", 0, time);
    static File file_a = new File(src,"a",64,time);
    static File file_b = new File(src, "b", 128, time);
    static File file_c = new File(lib,"c",32,time);
    static File file_d = new File(srctest,"d",1024,time);
    static File file_x = new File(root,"x",0,time);
    //Creating link
    static Link link_y = new Link(root,"y",0,time,srctest);

    @BeforeAll
    static void createFS(){
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
    public void testRootDirectoriesCount() {
        CountingVisitor countingVisitor = new CountingVisitor();
        root.accept(countingVisitor);
        assertEquals(5,countingVisitor.getDirNum());
    }

    @Test
    public void testLinksForRoot() {
        CountingVisitor countingVisitor = new CountingVisitor();
        root.accept(countingVisitor);
        assertEquals(1,countingVisitor.getLinkNum());
    }

    @Test
    public void testLinksForTest() {
        CountingVisitor countingVisitor = new CountingVisitor();
        test.accept(countingVisitor);
        assertEquals(0,countingVisitor.getLinkNum());
    }
    @Test
    public void testFilesForSrc() {
        CountingVisitor countingVisitor = new CountingVisitor();
        src.accept(countingVisitor);
        assertEquals(2,countingVisitor.getFileNum());
    }

    @Test
    public void testFilesForSrcTest() {
        CountingVisitor countingVisitor = new CountingVisitor();
        srctest.accept(countingVisitor);
        assertEquals(1,countingVisitor.getFileNum());
    }

    @Test
    public void testLibFilesCount() {
        CountingVisitor countingVisitor = new CountingVisitor();
        lib.accept(countingVisitor);
        assertEquals(1,countingVisitor.getFileNum());
    }
    @Test
    public void testDirectoriesForTest() {
        CountingVisitor countingVisitor = new CountingVisitor();
        test.accept(countingVisitor);
        assertEquals(2,countingVisitor.getDirNum());
    }
}
