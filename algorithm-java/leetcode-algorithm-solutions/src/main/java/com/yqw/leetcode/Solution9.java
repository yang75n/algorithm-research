package com.yqw.leetcode;

public class Solution9 {
    public boolean isPalindrome(int x) {

//        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
//        return (x + "").equals(reversedStr);


        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;

    }

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(8));
        System.out.println(new Solution9().isPalindrome(121));
        System.out.println(new Solution9().isPalindrome(-121));

    }
}
