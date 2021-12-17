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
 * @date Created in 2021年09月28日 14:23
 * @since 1.0
 */
public class 爬楼梯 {


    /**
     * 思路:
     * 1.动态规划,找出其递推公式
     * 2.递推公式为
     *
     * @param n 楼梯阶数
     * @return 爬楼梯有几种方式
     */
    public int climbStairs(int n) {
        // 设置一个dp数组代表其行走的步数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // f(x) = f(x-1) + f(x-2);
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
