package com.squirrel.java.leet.数组;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月28日 15:34
 * @since 1.0
 */
public class 最长重复数组 {

    /**
     * 思路:
     * 1.查询子数组的长度
     * 2.通过动态规划
     * 3.递推公式: dp[i][j]代表子数组长度
     *
     * @param A 数组 A
     * @param B 数组B
     * @return 数组长度
     */
    public int findLength(int[] A, int[] B) {
        // 找公式
        int m = A.length;
        int n = B.length;
        int ans = 0;
        //
        int[][] dp = new int[m + 1][n + 1];  // dp[i][j]表示A的前i项与B的前j项的最长重复子数组长度
        //
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
