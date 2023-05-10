package edu.umb.cs680.hw14.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children = new LinkedList<>();
    private int totalSize;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren() {
        //for default Alphabetical sorting
        Collections.sort(children,(fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        return children;
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){
        LinkedList<FSElement> sortedChildren = new LinkedList<>(children);
        Collections.sort(sortedChildren, comparator);
        return sortedChildren;
    }

    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement fs : children) {
            if (fs.isDirectory()) {
                subDirectories.add((Directory) fs);
            }
        }
        //for default Alphabetical sorting
        Collections.sort(subDirectories,(fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        return subDirectories;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator){
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement fs : children) {
            if (fs.isDirectory()) {
                subDirectories.add((Directory) fs);
            }
        }
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (!fsElement.isDirectory() && !fsElement.isLink()) {
                files.add((File) fsElement);
            }
        }
        //for default Alphabetical sorting
        Collections.sort(files,(fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator){
        LinkedList<File> files = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (!fsElement.isDirectory() && !fsElement.isLink()) {
                files.add((File) fsElement);
            }
        }
        Collections.sort(files, comparator);
        return files;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> Links = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (fsElement.isLink()) {
                Links.add((Link) fsElement);
            }
        }
        //for default Alphabetical sorting
        Collections.sort(Links,(fs1, fs2) -> fs1.getName().compareTo(fs2.getName()));
        return Links;
    }

    public int getTotalSize() {
        totalSize=0;
        for (FSElement fsElement : children) {
            if (fsElement.isDirectory()) {
                totalSize = totalSize + ((Directory) fsElement).getTotalSize();
            } else {
                totalSize = totalSize + fsElement.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e: children){
            e.accept(v);
        }
    }

}
