package com.squirrel.java.leet.数组;

import java.util.ArrayList;
import java.util.List;

public class 子集 {


    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


}
