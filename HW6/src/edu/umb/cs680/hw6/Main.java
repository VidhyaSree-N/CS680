package edu.umb.cs680.hw6;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();

        Directory root = new Directory(null,"root", 0, time);
        Directory src = new Directory(root,"src", 0, time);
        Directory lib = new Directory(root,"lib", 0, time);
        Directory test = new Directory(root,"test", 0, time);
        Directory srctest = new Directory(root,"srctest", 0, time);

        root.appendChild(src);
        root.appendChild(lib);
        root.appendChild(test);

        System.out.println("children count : "+root.countChildren());
        System.out.println("Adding another child");
        root.appendChild(srctest);
        System.out.println("children count : "+ root.countChildren());
    }
}
