package edu.umb.cs680.hw7;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FilesystemTest {

    private static LocalDateTime time;
    private static SingletonFilesystem singletonFilesystem;

    @BeforeEach
    public void setup(){
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


}
