package com.yqw.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(m);
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        System.out.println(Arrays.toString(new Solution1().twoSum(nums, 6)));
    }
}
