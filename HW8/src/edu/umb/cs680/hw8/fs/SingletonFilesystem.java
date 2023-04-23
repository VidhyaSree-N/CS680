package edu.umb.cs680.hw8.fs;

import java.util.LinkedList;

public class SingletonFilesystem {
    private static SingletonFilesystem instance = null;
    private LinkedList<Directory> rootDirs;

    private SingletonFilesystem() {
        this.rootDirs = new LinkedList<>();
    }

    public static SingletonFilesystem getFileSystem() {
        if (instance == null) {
            instance = new SingletonFilesystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void appendRootDirectory(Directory root) {
        this.rootDirs.add(root);
    }
}
