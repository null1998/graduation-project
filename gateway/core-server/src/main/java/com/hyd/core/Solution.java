package com.hyd.core;
public class Solution {
    char[][] matrix;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] grid) {
        // write code here
        if (grid == null) {
            return 0;
        }
        int result = 0;
        matrix = grid;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                } else {
                    result++;
                    dfs(i, j);
                }
            }
        }
        return result;
    }
    public void dfs(int x, int y) {
        if (x >= 0 && x < matrix.length && y >= 0 && y <matrix[0].length && matrix[x][y] == '1') {
            for (int k = 0; k < 4; k++) {
                int nr = dr[k] + x;
                int nc = dc[k] + y;
                matrix[x][y] = '0';
                dfs(nr, nc);
            }
        }
    }
}
