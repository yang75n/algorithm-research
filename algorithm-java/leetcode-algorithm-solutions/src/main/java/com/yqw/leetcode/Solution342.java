package com.yqw.leetcode;

public class Solution342 {

    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution342().isPowerOfFour(4));
        System.out.println(new Solution342().isPowerOfFour(8));

    }
}
