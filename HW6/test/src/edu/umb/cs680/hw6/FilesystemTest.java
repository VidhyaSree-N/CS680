package edu.umb.cs680.hw6;


import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemTest {

    private static SingletonFilesystem fs;

    @BeforeAll
    public static void setUp() {
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void singletonTest() {
        SingletonFilesystem singletonFilesystem2 = SingletonFilesystem.getFileSystem();
        assertSame(fs, singletonFilesystem2);
    }

    @Test
    public void appendRootTest() {
        Directory root = new Directory(null, "Root", 0, LocalDateTime.now());
        Directory expected = root;
        Directory actual = fs.getRootDirs().getFirst();

        assertEquals(expected.size, actual.size);

    }

    @Test
    public void rootDirectoryTest(){
        Directory actual = fs.getRootDirs().get(0);
        assertEquals(4,actual.countChildren());

    }

    @AfterAll
    public static void print(){
        System.out.println("Test Cases Completed");
    }


}
