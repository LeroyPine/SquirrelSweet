package com.squirrel.java.leet.树.meet;

public class 验证平衡二叉树 {


    /**
     * 思路:
     * 1.自底向上
     * 2.任何一个子树的高度大于1,那么这棵树就是不平衡的
     * 3.递归就相当于压栈、压栈啊啊啊啊啊
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
