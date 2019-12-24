package com.yqw.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }

        HashMap<Character, Character> maps = new HashMap<>();
        maps.put('(', ')');
        maps.put('[', ']');
        maps.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (maps.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c != maps.get(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("((()(())))"));
    }
}
