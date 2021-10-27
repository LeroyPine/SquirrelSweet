package com.squirrel.java.leet.dp;

public class 最长上升子序列 {


    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // 定义dp
        int[] dp = new int[nums.length];
        dp[0] = 1;
        // 最长序列
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;

            // 依次
            for (int j = 0; j < i; j++) {
                dp[i] = 1;
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
