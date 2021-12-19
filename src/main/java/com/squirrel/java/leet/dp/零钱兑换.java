package com.squirrel.java.leet.dp;

import java.util.Arrays;

public class 零钱兑换 {


    /**
     * 思路:
     * 1.找出递推公式
     * 2.设i为金额, f(i) =  f(i-coins[j])+1 , || i-coins[j]  组成这个金额上一个金额
     *
     * @param coins  硬币
     * @param amount 金额
     * @return 组成金额的最少硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        // amount ：金额  dp[i]代表几种方法可以组成这个金额
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        // 
        for (int i = 1; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
