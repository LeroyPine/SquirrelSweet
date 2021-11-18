package com.squirrel.java.leet.数组;

import java.util.ArrayList;
import java.util.List;

public class 子集 {


    public List<List<Integer>> subsets(int[] nums) {
        // 路径变量-记录节点信息

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        dfs(0, nums, list, ans);
        return ans;
    }

    private void dfs(int cur, int[] nums, List<Integer> list, List<List<Integer>> ans) {

        // 首先寻找递归终止条件

        if (cur == nums.length){
            ans.add(list);
            return;
        }

        // 遍历没有选择的情况下
        dfs(cur+1,nums,list,ans);
        // 选择当前元素的情况下
        list.add(nums[cur]);
        dfs(cur+1,nums,list,ans);



    }


}
