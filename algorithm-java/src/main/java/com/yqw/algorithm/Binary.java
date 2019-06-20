package com.yqw.algorithm;

import org.junit.Test;

/**
 * 2019/6/18.
 */
public class Binary {

    // 统计一个整数的二进制表示中bit为1的个数.
    @Test
    public void testBinary() {
        int n = 1;
        int c = 0;
        while (n > 0) {
            if ((n & 1) == 1) // 当前位是1
                ++c; // 计数器加1
            n >>= 1; // 移位
        }
        System.out.println("个数=" + c);
    }
}