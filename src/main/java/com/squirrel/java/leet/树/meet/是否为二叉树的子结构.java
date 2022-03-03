package com.squirrel.java.leet.树.面试;

public class 是否为二叉树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        // 判断是否是二叉树
        if (root1 == null || root2 == null) {
            return false;
        }

        return isSubTree(root1, root2);

    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        // 根节点作为子树  或者  左右子树的节点为子树

        if (judge(root1, root2)) {
            return true;
        } else {
            return judge(root1.left, root2) || judge(root1.right, root2);
        }
    }

    private boolean judge(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return judge(root1.left, root2.left) && judge(root1.right, root2.right);
        }
        return false;
    }
}
