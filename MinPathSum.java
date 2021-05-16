package com.test.week05;

public class MinPathSum {

    /*
     * 思路1： 时间复杂度O(m+n+mn)
     * 暴力动态规划：二维数组dp[m][n]
     * 移动规律：只能往右或者往下
     * 边界1：当m=0：路径和是dp[0][n] = dp[0][n-1] + dp[0][n]
     * 边界2：当n=0:路径和是dp[m][0] = dp[m-1][0] + dp[m][0]
     * 选则最小路径:
     * dp[m][n] = Math.min(dp[m][n]+dp[m-1][n],dp[m][n]+dp[m][n-1])
     * 或者dp[m][n] = Math.min(dp[m-1][n],dp[m][n-1]) + dp[m][n]
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        // 边界1
        for(int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        // 边界2
        for(int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
