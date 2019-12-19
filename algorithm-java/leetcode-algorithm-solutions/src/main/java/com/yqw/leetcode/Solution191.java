package com.yqw.leetcode;

public class Solution191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);//将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
        }
        return sum;

    }

    public static void main(String[] args) {


        System.out.println(new Solution191().hammingWeight(3));
    }
}
