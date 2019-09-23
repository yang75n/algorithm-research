package com.yqw.algorithm.search;

public class SearchUtils {

    public static int linearSearchSorted(int[] sortedData, int value) {

        for (int i = 0; i < sortedData.length; i++) {
            System.out.println(sortedData[i] + " " + value);
            if (sortedData[i] == value) {
                return i;
            }
            if (value < sortedData[i]) {
                return -1;
            }
        }
        return -1;
    }

    public static int binarySearchSorted(int sortedData, int value) {

        return -1;
    }

    public static int binarySearchSortedRecursion(int[] sortedData, int offset, int len, int value) {

        int mid = (offset + len) / 2;
        if (sortedData[mid] == value) {
            return mid;
        }
        if (mid == offset) {
            if (sortedData[len] == value) {
                return len;
            } else {
                return -1;
            }
        }
        if (sortedData[mid] < value) {
            return binarySearchSortedRecursion(sortedData, mid, len, value);
        } else if (sortedData[mid] > value) {
            return binarySearchSortedRecursion(sortedData, offset, mid, value);
        }
        return -1;
    }


}
