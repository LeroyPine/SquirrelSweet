package com.squirrel.java.leet.dp;

public class 最小路径和 {


    /**
     * 思路:
     * 1.动态规划
     * 2.
     *
     * @param grid 网格
     * @return 最小路径之和
     */
    public int minPathSum(int[][] grid) {
        //  首先判断是否符合条件
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 找出二维数组的大小
        int row = grid.length;
        int col = grid[0].length;

        // 定义dp数组
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            // 动态规划表达式： dp[i][j] 代表了最小路径之和,所以路径之和等于什么呢？ 就是当前格子的数值+初始值。
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 最终按照普通的动态规划公式寻找
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // 向下或者向右面走
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];

    }


}
