package com.barson.lists;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{

    private static final int DEFAULT_ARRAY_SIZE = 10;

    private T[] array;
    private int size;

    public MyArrayList() {
        this(DEFAULT_ARRAY_SIZE);
    }

    public MyArrayList(int size) {
        array = (T[])new Object[size];
    }

    public MyArrayList(MyList<T> list) {
        //add list to array
    }

    @Override
    public void add(T element) {
        array[size++] = element;
        if (size >= array.length) {
            T[] newList = (T[])new Object[array.length * 2];
            System.arraycopy(array, 0, newList, 0, array.length);
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        array[index] = null;
        System.arraycopy(array, index+1, array, index, --size);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return array[index];
    }

    @Override
    public void clear() {
        array = (T[])new Object[DEFAULT_ARRAY_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator iterator() {
        return new MyArrayListIterator(this);
    }

    class MyArrayListIterator<T> implements Iterator<T> {

        private MyArrayList<T> myArrayList;
        private int currentIndex;

        private MyArrayListIterator(MyArrayList<T> myArrayList) {
            this.myArrayList = myArrayList;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < myArrayList.size();
        }

        @Override
        public T next() {
            return myArrayList.get(currentIndex++);
        }
    }
}
