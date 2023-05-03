package edu.umb.cs680.hw6;


import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemTest {

    private static LocalDateTime time;
    private static SingletonFilesystem singletonFilesystem;

    @BeforeAll
    public static void setup(){
        time = LocalDateTime.now();
        singletonFilesystem = SingletonFilesystem.getFileSystem();

    }

    @Test
    public void singletonTest() {
        SingletonFilesystem singletonFilesystem2 = SingletonFilesystem.getFileSystem();
        assertSame(singletonFilesystem, singletonFilesystem2);
    }

    @Test
    public void appendRootTest() {
        Directory root = new Directory(null, "Root", 0, time);
        singletonFilesystem.appendRootDirectory(root);

        Directory[] expected = { root };
        Directory[] actual = singletonFilesystem.getRootDirs().toArray(new Directory[0]);

        assertArrayEquals(expected, actual);

    }

    @Test
    public void rootDirectoryTest(){
        Directory[] actual = singletonFilesystem.getRootDirs().toArray(new Directory[0]);
        assertEquals(1,actual.length);

    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }


}
