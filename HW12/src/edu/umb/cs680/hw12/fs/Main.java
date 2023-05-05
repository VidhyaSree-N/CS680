package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();
        Directory root = new Directory(null,"root", 0, time);
        Directory src = new Directory(root,"src", 0, time);
        Directory lib = new Directory(root,"lib", 0, time);
        Directory test = new Directory(root,"test", 0, time);
        Directory srctest = new Directory(test,"src", 0, time);
        File file_a = new File(src,"a",64,time);
        File file_b = new File(src, "b", 128, time);
        File file_c = new File(lib,"c",32,time);
        File file_d = new File(srctest,"d",1024,time);
        File file_x = new File(root,"x",1678,time);
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

        Directory directory = root;

        System.out.println("Default sorting");
        List<FSElement> fse = directory.getChildren();
        System.out.println(fse.get(0).name);
        System.out.println(fse.get(1).name);
        System.out.println(fse.get(2).name);
        System.out.println(fse.get(3).name);

        System.out.println("Time based sorting");
        List<FSElement> timebased = directory.getChildren(new TimeBased());
        System.out.println(timebased.get(0).name);
        System.out.println(timebased.get(1).name);
        System.out.println(timebased.get(2).name);
        System.out.println(timebased.get(3).name);

        System.out.println("Size based sorting");
        List<FSElement> sizebased = directory.getChildren(new SizeBased());
        System.out.println(sizebased.get(0).name);
        System.out.println(sizebased.get(1).name);
        System.out.println(sizebased.get(2).name);
        System.out.println(sizebased.get(3).name);

        System.out.println("Reverse Aphabetical sorting");
        List<FSElement> reverse = directory.getChildren(new ReverseAlphabetical());
        System.out.println(reverse.get(0).name);
        System.out.println(reverse.get(1).name);
        System.out.println(reverse.get(2).name);
        System.out.println(reverse.get(3).name);

        System.out.println("Element Based sorting");
        List<FSElement> element = directory.getChildren(new ElementBased());
        System.out.println(element.get(0).name);
        System.out.println(element.get(1).name);
        System.out.println(element.get(2).name);
        System.out.println(element.get(3).name);

        System.out.println("Reverse Element Based sorting");
        List<FSElement> relement = directory.getChildren(new ReverseElementBased());
        System.out.println(relement.get(0).name);
        System.out.println(relement.get(1).name);
        System.out.println(relement.get(2).name);
        System.out.println(relement.get(3).name);



    }
}
