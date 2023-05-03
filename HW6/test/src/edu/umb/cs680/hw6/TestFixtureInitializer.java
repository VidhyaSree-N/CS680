package edu.umb.cs680.hw6;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

        public static LocalDateTime time;
        public static Directory root;
        public static Directory src;
        public static Directory lib;
        public static Directory test;
        public static Directory srctest;
        public static File file_a;
        public static File file_b;
        public static File file_c;
        public static File file_d;
        public static File file_x;

        public static SingletonFilesystem createFS() {
            SingletonFilesystem fs = SingletonFilesystem.getFileSystem();
            time = LocalDateTime.now();
            root = new Directory(null, "root", 0, time);
            src = new Directory(root, "src", 0, time);
            lib = new Directory(root, "lib", 0, time);
            test = new Directory(root, "test", 0, time);
            srctest = new Directory(test, "src", 0, time);
            file_a = new File(src, "a", 64, time);
            file_b = new File(src, "b", 128, time);
            file_c = new File(lib, "c", 32, time);
            file_d = new File(srctest, "d", 1024, time);
            file_x = new File(root, "x", 0, time);

            root.appendChild(src);
            root.appendChild(lib);
            root.appendChild(test);
            test.appendChild(srctest);
            src.appendChild(file_a);
            src.appendChild(file_b);
            lib.appendChild(file_c);
            srctest.appendChild(file_d);
            root.appendChild(file_x);

            return fs;
        }

        public static void tearDown() {
            time = null;
            root = null;
            src = null;
            lib = null;
            test = null;
            srctest = null;
            file_a = null;
            file_b = null;
            file_c = null;
            file_d = null;
            file_x = null;
        }
    }

