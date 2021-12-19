package com.squirrel.java.leet.dp;

public class 最长公共子序列 {

    /**
     * 思路:
     * 1.采用二维数组,动态规划
     * 2.找出递推关系式
     * 3. dp[i][j]
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            char textM = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char textN = text2.charAt(j - 1);
                if (textM == textN) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
