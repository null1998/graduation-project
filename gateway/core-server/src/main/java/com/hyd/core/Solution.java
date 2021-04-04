package com.hyd.core;
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        // write code here
        if (str != null) {
            int left = 0;
            int right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left++) != str.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
