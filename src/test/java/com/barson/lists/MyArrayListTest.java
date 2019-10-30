package com.barson.lists;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test public void testEmptyListCreationIsEmpty() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        assertEquals(0, myList.size());
    }

    @Test public void testAdd1ElementToListHasSize1() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        assertEquals(1, myList.size());
    }

    @Test public void testRemoveOnEmptyListThrowsException() {
        MyArrayList<Integer> myList = new MyArrayList<>();

        Exception ex = null;
        try {
            myList.remove(0);
        } catch (Exception e) {
            ex = e;
        }

        assertNotNull(ex);
        assertTrue("Check Exception is correct type", ex instanceof IndexOutOfBoundsException);
    }

    @Test public void testAdd1ThenRemove1IsEmpty() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.remove(0);
        assertEquals(0, myList.size());
    }

    @Test public void testAdd3ThenRemove1HasSize2() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.remove(2);
        assertEquals(2, myList.size());
    }

    @Test public void testAddElementForValue() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        assertEquals(1, (int)myList.get(0));
    }

    @Test public void testAdd3ThenRemove1FromMiddleForValues() {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.remove(1);
        assertArrayEquals(new int[]{1, 3}, new int[]{myList.get(0), myList.get(1)} );
    }
}
