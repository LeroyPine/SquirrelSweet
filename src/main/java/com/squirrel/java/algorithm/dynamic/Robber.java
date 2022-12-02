package com.squirrel.java.algorithm.dynamic;

import com.squirrel.java.entity.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luobaosong
 * @date 2022/11/28 12:56
 * @description
 **/
@Slf4j
public class Robber {

    public static void main(String[] args) {
        Robber robber = new Robber();
        int rob = robber.rob(new int[]{8, 13, 3, 9, 5});
        log.info("rob:{}", rob);

        int robDp = robber.robDp(new int[]{8, 13, 3, 9, 5});
        log.info("robDp:{}", robDp);

        robber.robDpV2(new int[]{1, 2, 3});
    }


    /**
     * 抢劫
     *
     * @param nums 全国矿工工会
     * @return int
     */
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return doRob(nums, 0, memo);
    }

    private int doRob(int[] nums, int startIndex, int[] memo) {
        // 递归终止条件
        if (startIndex >= nums.length) {
            return 0;
        }
        if (memo[startIndex] != -1) {
            return memo[startIndex];
        }
        int noRob = doRob(nums, startIndex + 1, memo);
        int rob = doRob(nums, startIndex + 2, memo) + nums[startIndex];
        int res = Math.max(noRob, rob);
        memo[startIndex] = res;
        return res;
    }


    public int robDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }


    /**
     * 分析存在几种情况
     * 1. ~ 不能偷首尾, 偷第一间 不偷最后一间
     * 2. 偷最后一间 不偷第一间
     *
     * @param nums 全国矿工工会
     * @return int
     */
    public int robDpV2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robDpV2(nums, 1, n - 1), robDpV2(nums, 0, n - 2));
    }

    private int robDpV2(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }


    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.get(root) != null) {
            return memo.get(root);
        }

        // rob

        int rob = root.val +
                (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0) +
                (root.right != null ? rob(root.right.right) + rob(root.right.left) : 0);

        // notRob
        int notRob = rob(root.left) + rob(root.right);

        int res = Math.max(rob, notRob);
        memo.put(root, res);
        return res;

    }


}
