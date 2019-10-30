package com.barson.lists;

public interface MyList<T> extends Iterable {

    public void add(T element);

    public void remove(int index);

    public T get(int index);

    public void clear();

    public int size();

    public boolean isEmpty();

}
