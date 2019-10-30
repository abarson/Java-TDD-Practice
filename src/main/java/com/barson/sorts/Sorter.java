package com.barson.sorts;


import com.barson.lists.MyList;

public interface Sorter<T> {

    public void inPlaceSort(MyList<T> list);

}
