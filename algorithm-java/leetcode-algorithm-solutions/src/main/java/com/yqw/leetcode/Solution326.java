package com.yqw.leetcode;

public class Solution326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //
    public static void main(String[] args) {
        System.out.println(new Solution326().isPowerOfThree(3));
        System.out.println(new Solution326().isPowerOfThree(5));
    }
}
