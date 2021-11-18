package com.squirrel.java.leet.回溯;


import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {

        // 递归终止条件
        if (root == null) {
            return;
        }
        path.add(root.val);

        targetSum = targetSum - root.val;
        // 找到结束的条件
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(path);
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);


    }


}
