package edu.umb.cs680.hw8.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return this.target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }
}
