package com.squirrel.java.leet.dp;

public class 最长上升子序列 {


    /**
     * 思路:
     * 1.dp 记录每块的长度
     * 2.通过循环的方式,不过有判断逻辑,可以减少时间复杂度
     * 3.math.max 记录最大值
     *
     * @param nums 数组
     * @return 长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 比较元素之间的大小,如果小 那么就累加长度
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
