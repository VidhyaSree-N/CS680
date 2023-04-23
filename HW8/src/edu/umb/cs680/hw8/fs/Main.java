package edu.umb.cs680.hw8.fs;

import edu.umb.cs680.hw8.fs.util.FileSearchVisitor;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();

        Directory root = new Directory(null,"root", 0, time);
        File file_b = new File(root, "b", 128, time);

        root.appendChild(file_b);

        System.out.println("Searching for file...");
        FileSearchVisitor visitor = new FileSearchVisitor("b");
        root.accept(visitor);
        System.out.println("Found file : "+ visitor.getFoundFiles().get(0).getName());
    }
}
