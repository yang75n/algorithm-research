package com.yqw.algorithm.sort;

import java.util.Random;

/**
 * Sort的测试类
 * 2019/6/18.
 */
public class SortTest {

    private static Sort sort = new Sort();
    private static final int COUNT = 10;

    public static void main(String[] args) {

        System.out.printf("----------------------------------\n");


        int count = COUNT;
        if (args.length > 1)
            count = Integer.valueOf(args[1]);
        if (count < 1)
            count = 1;

        //int tmp[ count];
        int tmp[] = new int[count];
        //srand(time(NULL));
        System.out.printf("new an array randomly\n");
        for (int i = 0; i < count; ++i)
            tmp[i] = new Random().nextInt() % count + 1;
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", tmp[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        // int arr[ count];
        int arr[] = new int[count];

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.select_sort(arr, count);
        System.out.printf("%s\n", "select sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.select_2way_sort(arr, count);
        System.out.printf("%s\n", "two way select sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.bubble_sort(arr, count);
        System.out.printf("%s\n", "bubble sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.bubble_2way_sort(arr, count);
        System.out.printf("%s\n", "two direction bubble sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.insert_sort(arr, count);
        System.out.printf("%s\n", "insert sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.insert_binary_sort(arr, count);
        System.out.printf("%s\n", "binary insert sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.insert_2way_sort(arr, count);
        System.out.printf("%s\n", "two way insert sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.heap_sort(arr, count);
        System.out.printf("%s\n", "heap sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.quick_sort(arr, 0, count - 1);
        System.out.printf("%s\n", "quick sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.shell_sort(arr, count);
        System.out.printf("%s\n", "shell sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.merge_sort(arr, 0, count - 1);
        System.out.printf("%s\n", "merge sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

        for (int i = 0; i < count; ++i)
            arr[i] = tmp[i];
        sort.count_sort(arr, count);
        System.out.printf("%s\n", "count sort");
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.printf("\n");
        System.out.printf("\n");

    }
}
