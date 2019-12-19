package com.yqw.leetcode;

public class Solution231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution231().isPowerOfTwo(64));
        System.out.println(new Solution231().isPowerOfTwo(48));
        System.out.println(new Solution231().isPowerOfTwo(0));
    }
}