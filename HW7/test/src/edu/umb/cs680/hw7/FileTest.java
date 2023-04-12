package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

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
}
