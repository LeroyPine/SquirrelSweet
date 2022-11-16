package com.squirrel.java.algorithm.tree;

import java.util.Arrays;

/**
 * @author luobaosong
 * @date 2022/11/14 09:38
 * @description
 **/
public class CoinChange {


    /**
     * dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
     *
     * @param coins  硬币
     * @param amount 量
     * @return int
     */
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        // 设置初始化值
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
