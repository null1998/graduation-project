package com.hyd.financial.util;

import java.util.*;


public class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (brackets(c) == 0) {
                stack.offerLast(c);
            } else if (brackets(c) == 1) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pollLast();
                if (c-top==1||c-top==2) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public int brackets(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return 0;
        }
        if (c == ')' || c == ']' || c == '}') {
            return 1;
        }
        return -1;
    }
}
