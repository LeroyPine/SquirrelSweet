package com.squirrel.java.leet.树.面试;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的完全性校验 {


    /**
     * 思路:
     * 1.使用二叉树的层序遍历加入到集合中
     * 2.如果在遍历集合的时候如果 空值后面还有元素的话就不是完全二叉树
     *
     * @param root 根节点
     * @return 是否是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        // 层序遍历
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isComplete = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            // 只有最后一个元素可以为空
            if (poll != null) {
                if (isComplete) {
                    return false;
                }
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                isComplete = true;
            }
        }
        return isComplete;
    }
}
