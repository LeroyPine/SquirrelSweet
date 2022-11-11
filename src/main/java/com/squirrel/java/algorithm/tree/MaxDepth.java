package com.squirrel.java.algorithm.tree;

import com.squirrel.java.entity.TreeNode;

/**
 * @author luobaosong
 * @date 2022/11/11 14:20
 * @description
 **/
public class MaxDepth {

    public int res;
    public int depth;

    public void traverseMaxDepth(TreeNode root) {
        // 遍历
        traverse(root);

    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        // 不必每次都更新,到叶子节点在更新
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 分解～
        return Math.max(leftMax, rightMax) + 1;
    }

}
