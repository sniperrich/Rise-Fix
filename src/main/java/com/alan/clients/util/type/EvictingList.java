package com.alan.clients.util.type;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class EvictingList<T> extends LinkedList<T> implements Serializable {

    private int maxSize;

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public EvictingList(int maxSize) {
        this.maxSize = maxSize;
    }

    public EvictingList(Collection<? extends T> c, int maxSize) {
        super(c);
        this.maxSize = maxSize;
    }


    public boolean add(T t) {
        if (size() >= getMaxSize()) removeFirst();
        return super.add(t);
    }

    public boolean isFull() {
        return (size() >= getMaxSize());
    }
}