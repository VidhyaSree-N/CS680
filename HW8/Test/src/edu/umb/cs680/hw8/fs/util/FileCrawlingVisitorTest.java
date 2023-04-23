package edu.umb.cs680.hw8.fs.util;

import edu.umb.cs680.hw8.fs.Directory;
import edu.umb.cs680.hw8.fs.File;
import edu.umb.cs680.hw8.fs.Link;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileCrawlingVisitorTest {

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
}
