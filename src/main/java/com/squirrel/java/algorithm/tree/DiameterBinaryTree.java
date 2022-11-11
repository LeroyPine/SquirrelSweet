package com.squirrel.java.algorithm.tree;

import com.squirrel.java.entity.TreeNode;

/**
 * @author luobaosong
 * @date 2022/11/11 17:28
 * @description
 **/
public class DiameterBinaryTree {

    public int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}
