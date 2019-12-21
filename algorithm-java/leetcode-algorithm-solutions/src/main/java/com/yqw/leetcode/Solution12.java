package com.yqw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution12 {

    public String intToRoman(int num) {

        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num >= arab[index]) {
                res.append(roman[index]);
                num -= arab[index];
            } else {
                index++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution12().intToRoman(40));
        System.out.println(new Solution12().intToRoman(8));
        System.out.println(new Solution12().intToRoman(102));
    }
}