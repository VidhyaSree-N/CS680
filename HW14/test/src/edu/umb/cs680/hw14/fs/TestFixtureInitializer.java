package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

        public static SingletonFilesystem createFS() {
            SingletonFilesystem fs = SingletonFilesystem.getFileSystem();
            LocalDateTime time = LocalDateTime.now();
            Directory root = new Directory(null, "root", 0, time);
            Directory src = new Directory(root, "src", 0, time);
            Directory lib = new Directory(root, "lib", 0, time);
            Directory test = new Directory(root, "test", 0, time);
            Directory srctest = new Directory(test, "src", 0, time);
            File file_a = new File(src, "a", 64, time);
            File file_b = new File(src, "b", 128, time);
            File file_c = new File(lib, "c", 32, time);
            File file_d = new File(srctest, "d", 1024, time);
            File file_x = new File(root, "x", 0, time);
            Link link_y = new Link(root,"y",0,time,srctest);

            fs.appendRootDirectory(root);

            root.appendChild(src);
            root.appendChild(lib);
            root.appendChild(test);
            test.appendChild(srctest);
            src.appendChild(file_a);
            src.appendChild(file_b);
            lib.appendChild(file_c);
            srctest.appendChild(file_d);
            root.appendChild(file_x);
            root.appendChild(link_y);

            return fs;
        }
    }

