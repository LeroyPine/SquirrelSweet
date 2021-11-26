package com.squirrel.java.leet.dp;

public class 最长上升子序列 {


    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
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

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[i] + 1);
                }

            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    /**
     *  if (nums.length == 0) {
     *             return 0;
     *         }
     *         // 动态规划来实现
     *         int[] dp = new int[nums.length];
     *         dp[0] = 1;
     *         // 定义结果
     *         int ans = 1;
     *         for (int i = 1; i < nums.length; i++) {
     *             dp[i] = 1;
     *             for (int j = 0; j < i; j++) {
     *                 if (nums[j] < nums[i]) {
     *                     dp[i] = Math.max(dp[i], dp[j] + 1);
     *                 }
     *             }
     *             ans = Math.max(ans, dp[i]);
     *
     *         }
     *         return ans;
     */
}
