package edu.umb.cs680.hw8.fs;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FilesystemTest {

    private LocalDateTime time = LocalDateTime.now();

    @Test
    public void singletonTest() {
        SingletonFilesystem fs1 = SingletonFilesystem.getFileSystem();
        SingletonFilesystem fs2 = SingletonFilesystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void appendRootTest() {
        Directory root = new Directory(null, "Root", 0, time);
        SingletonFilesystem singletonFilesystem = SingletonFilesystem.getFileSystem();
        singletonFilesystem.appendRootDirectory(root);

        Directory[] expected = { root };
        Directory[] actual = singletonFilesystem.getRootDirs().toArray(new Directory[0]);

        assertArrayEquals(expected, actual);

    }

    @Test
    public void rootDirectoryTest(){
        SingletonFilesystem singletonFilesystem = SingletonFilesystem.getFileSystem();
        Directory[] actual = singletonFilesystem.getRootDirs().toArray(new Directory[0]);
        int size = actual.length;

        assertEquals(1,size);

    }


}
