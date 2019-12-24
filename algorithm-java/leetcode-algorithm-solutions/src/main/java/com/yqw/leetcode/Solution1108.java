package com.yqw.leetcode;

public class Solution1108 {

    public String defangIPaddr(String address) {

        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        System.out.println(new Solution1108().defangIPaddr("192.168.128.72"));
    }
}