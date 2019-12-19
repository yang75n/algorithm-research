package com.yqw.leetcode;

public class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {

            //写法1
//            int bit = n & 1;//n % 2
//            n = n >>> 1;
//            res = (res << 1) + bit;

            //写法2
//            res <<= 1;  //res 左移一位空出位置
////            res |= (n & 1); //得到的最低位加过来
////            n >>>= 1;//原数字右移一位去掉已经处理过的最低位

            //下面是最简化代码
            res = (res << 1) | (n & 1);
            n >>>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(-1 >> 1);
//        System.out.println(-1 >>> 1);
//        System.out.println(1 >> 1);
//
//        System.out.println(1 & 1);
//        System.out.println(2 & 1);
//        System.out.println(1 % 2);
//        System.out.println(2 % 2);
//        System.out.println(1<<1);
        System.out.println(new Solution190().reverseBits(1));
    }
}
