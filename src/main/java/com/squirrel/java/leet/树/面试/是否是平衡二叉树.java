package com.squirrel.java.leet.树.面试;

public class 是否是平衡二叉树 {


    // 自底向上
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);


        // 判断条件
        if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }


    }


}
