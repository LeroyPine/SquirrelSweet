package com.squirrel.java.leet.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {


    /**
     * 给定一个数组,  数组中的元素总和等于target
     *
     * @param candidates 数组候选元素
     * @param target     目标值
     * @return 元素的组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 声明答案
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 声明细粒度答案
        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates, target, ans, path, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int idx) {
        if (target<0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, path, i);
            path.remove(path.size() - 1);
        }

    }

}
