package com.squirrel.java.leet.树.meet;

import java.util.Deque;
import java.util.LinkedList;

public class 验证二叉搜索树 {


    /**
     * 思路:
     * 1.验证二叉搜索树
     * 2.二叉树的中序遍历是升序的
     * 3.可以中序遍历中判断是否有元素不是升序的
     * 4.中序遍历 初始化时候 stack不加入元素
     *
     * @param root 根节点
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        double inorder = -Double.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // root不为空 压栈左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈节点
            TreeNode pop = stack.pop();
            int val = pop.val;
            if (val <= inorder) {
                return false;
            }
            inorder = pop.val;
            root = pop.right;
        }
        return true;
    }
}
