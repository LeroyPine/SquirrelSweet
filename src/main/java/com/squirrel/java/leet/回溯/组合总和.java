package com.squirrel.java.leet.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {

    /**
     * 39. 组合总和
     * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
     * <p>
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     * 输入: candidates = [2,3,6,7], target = 7
     * 输出: [[7],[2,2,3]]
     * 示例 2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     * 示例 4：
     * <p>
     * 输入: candidates = [1], target = 1
     * 输出: [[1]]
     * 示例 5：
     * <p>
     * 输入: candidates = [1], target = 2
     * 输出: [[1,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution {


        /**
         * 给定一个数组,  数组中的元素总和等于target
         *
         * @param candidates
         * @param target
         * @return
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // 声明答案
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 声明细粒度答案
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            // 递归退出条件
            // 枚举结束的时候退出
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(combine));
                return;
            }
            // 跳过当前元素的
            dfs(candidates, target, ans, combine, idx + 1);
            // 回溯条件
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }


    }
}
