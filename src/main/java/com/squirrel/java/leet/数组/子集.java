package com.squirrel.java.leet.数组;

import java.util.ArrayList;
import java.util.List;

public class 子集 {


    /**
     * 思路:
     * 1.回溯算法
     * 2.向元素中添加子集,回溯-挨个试
     * 3.撤销选择记得
     *
     * @param nums 数组
     * @return 子集结果
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 路径变量
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, nums, list, ans);
        return ans;
    }

    private void dfs(int cur, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        // 首先寻找递归终止条件
        if (cur == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(cur + 1, nums, list, ans);
        // 撤销选择
        list.remove(list.size() - 1);
        // 在进行选择
        dfs(cur + 1, nums, list, ans);
    }


}
