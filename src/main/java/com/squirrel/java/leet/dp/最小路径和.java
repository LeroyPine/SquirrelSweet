package com.squirrel.java.leet.dp;

public class 最小路径和 {


    /**
     * 最小路径和
     *
     * @param grid
     * @return
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
        //
        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {

            // 动态规划表达式： dp[i][j] 代表了最小路径之和,所以路径之和等于什么呢？ 就是当前格子的数值+初始值。
            dp[0][i] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 最终按照普通的动态规划公式寻找

        for (int i = 1; i < row; i++) {

            for (int j = 1; j < row; j++) {

                // 向下或者向右面走
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }

        }

        return dp[row - 1][col - 1];

    }


}
