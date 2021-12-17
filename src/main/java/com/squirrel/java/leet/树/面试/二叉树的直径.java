package com.squirrel.java.leet.树.面试;

/**
 * 题目:给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class 二叉树的直径 {


    /**
     * 4 2 1 3    5  2  1  3
     * 思路:
     * 1.二叉树的最大直径
     * 2.直径,可以看做是左子树+右子树+然后获取到最大的值
     *
     * @param root 根节点
     * @return 直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // 递归计算数组最大深度,并记录深度
        depth(root);
        return ans;
    }

    private int ans = 0;

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        ans = Math.max(ans, leftDepth + rightDepth); // 最大直径,左子树深度+右子树深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
