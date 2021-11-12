package com.squirrel.java.leet.dp;

public class 零钱兑换2 {


    public int change(int amount, int[] coins) {

        int[] dp = new int[amount - 1];
        dp[0] = 1;

        for (int coin : coins) {

            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];

    }
}
