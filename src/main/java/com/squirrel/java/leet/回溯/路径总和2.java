package com.squirrel.java.leet.回溯;


import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {


    /**
     * 思路:
     * 1. 递归终止条件 root为null
     * 2. 添加路径的条件: 当前节点为叶子节点以及 targetSum==0;
     * 3. 每出栈一次要删除集合中的一个元素,再次进行选择
     *
     * @param root      根节点
     * @param targetSum 目标值
     * @return 路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void dfs(TreeNode root, int targetSum) {
        // 递归终止条件
        if (root == null) {
            return;
        }
        targetSum = targetSum - root.val;
        // 路径添加条件
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);

    }


}
