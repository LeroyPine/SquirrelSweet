package com.squirrel.java.leet.树.面试;

import java.util.Deque;
import java.util.LinkedList;

public class 是否为二叉树 {


    // 中序遍历判断是否为平衡二叉树
    public boolean isValidBST(TreeNode root) {

        //

        int order = -999999999;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {

            // 先将左节点压入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            // 中序遍历是升序的  如果当前节点值 小于前一个节点值 那么其不是平衡的
            if (root.val <= order) {
                return false;
            }
            order = root.val;
            root = root.right;
        }
        return true;

    }
}
