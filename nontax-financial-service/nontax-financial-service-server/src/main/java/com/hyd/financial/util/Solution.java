package com.hyd.financial.util;

import java.util.*;

public class Solution {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        for (int m = 0; m < n - 1; m++) {
            int x = 0;
            int y = m;
            int cur = mat[x][y];
            // 第一排的元素（除最后一个）

                // 四次旋转
                for (int j = 1; j <= (n + 1) / 2 - m || j == 1; j++) {
                    // 从对角线向中心
                    for (int i = 1; i <= 4; i++) {
                        int next = mat[y][n - 1 - x];
                        mat[y][n - 1 - x] = cur;
                        cur = next;
                        int nx = y;
                        int ny = n - 1 - x;
                        x = nx;
                        y = ny;
                    }

                }
        }
        return mat;

    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        mat = new Solution().rotateMatrix(mat,3);
        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.println(anInt);

            }
        }
    }
}
