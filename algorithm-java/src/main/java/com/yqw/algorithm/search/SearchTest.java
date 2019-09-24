package com.yqw.algorithm.search;

import com.yqw.algorithm.sort.SortUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class SearchTest {

    private static final int COUNT = 10;
    private int[] arr = new int[COUNT];

    @Before
    public void initData() {
        System.out.printf("new an array randomly :\n");
        for (int i = 0; i < COUNT; ++i)
            arr[i] = new Random().nextInt() % COUNT + 1;

        //排序
        SortUtils.quick_sort(arr, 0, arr.length - 1);

        for (int i = 0; i < COUNT; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.println();//换行
    }


    @Test
    public void testLinearSearch() {
        int index = SearchUtils.linearSearchSorted(arr, 0);
        System.out.println("target= " + index);
    }

    @Test
    public void testBinarySearch() {
        int index = SearchUtils.binarySearchSorted(arr, 0);
        System.out.println("target= " + index);
    }

    @Test
    public void testBinarySearchRecursion() {
        int index = SearchUtils.binarySearchSortedRecursion(arr, 0, arr.length, 0);
        System.out.println("target= " + index);
    }
}
