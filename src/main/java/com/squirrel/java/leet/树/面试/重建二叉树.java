package com.squirrel.java.leet.树.面试;

public class 重建二叉树 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root;
        root = rebuildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    // 重建二叉树
    private TreeNode rebuildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        // 首先找到递归结束条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        //找到根节点  前序遍历的第一个几点为根节点
        TreeNode root = new TreeNode(pre[preStart]);
        //去中序遍历数组中找到左右子树
        for (int i = inStart; i <= inEnd; i++) {
            // 寻找根节点


            if (in[i] == root.val) {
                // 可以计算出中序序列的左右子树序列为:左：inStart~i -1，右：i+1~inEnd。
                // 前序序列的左右子树：左：preStart+1~preStart+i-inStart，右：preStart+i-inStart+1~preEnd

                root.left = rebuildTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = rebuildTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }

        }

        return null;
    }


}
