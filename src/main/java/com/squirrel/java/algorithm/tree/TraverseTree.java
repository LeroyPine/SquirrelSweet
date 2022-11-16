package com.squirrel.java.algorithm.tree;

import com.squirrel.java.entity.TreeNode;

import java.util.*;

/**
 * 遍历树木 层序 or 递归
 *
 * @author luobaosong
 * @date 2022/11/12 09:34
 * @description
 **/
public class TraverseTree {

    /**
     * 层次遍历二叉树
     *
     * @param root 根
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // res
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> treeNodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                treeNodeList.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(treeNodeList);
        }
        return res;
    }
}
