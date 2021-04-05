package com.hyd.core;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve (String s) {
        // write code here
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                op.offerLast(c);
            } else if (c == ')') {
                char o = ' ';
                while ((o = op.pollLast()) != '(') {
                    if (o == '+') {
                        num.offerLast(num.pollLast() + num.pollLast());
                    } else if (o == '-') {
                        num.offerLast(num.pollLast() - num.pollLast());
                    } else if (o == '*') {
                        num.offerLast(num.pollLast() * num.pollLast());
                    }
                }

            } else if (c == '*') {
                if (s.charAt(i + 1) == '(') {
                    op.offerLast(c);
                } else {
                    num.offerLast(num.pollLast() * num.pollLast());
                }
            } else if (c == '+' || c == '-') {
                if (!op.isEmpty() && op.peekLast() == '*') {
                    num.offerLast(num.pollLast() * num.pollLast());
                    op.pollLast();
                }
                op.offerLast(c);
            } else {
                num.offerLast(c - 48);
            }
        }
        char o = ' ';
        while ((o = op.pollLast()) != '(') {
            if (o == '+') {
                num.offerLast(num.pollLast() + num.pollLast());
            } else if (o == '-') {
                num.offerLast(num.pollLast() - num.pollLast());
            } else if (o == '*') {
                num.offerLast(num.pollLast() * num.pollLast());
            }
        }
        return num.pollLast();
    }
}
