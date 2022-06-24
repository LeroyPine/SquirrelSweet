package com.squirrel.java.leet.树.meet;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树的最大宽度 {

    /**
     * 思路：
     * 1. 所用的算法知识点（完全二叉树的性质）：对于一颗完全二插树，如果按照从上至下，从左往右对所有节点从零开始顺序编号
     * 2. 则父节点的左孩子节点的序号：2*i+1   父节点的左孩子节点的序号：2*i+2;
     * 3. 所以每层的宽度就可以使用：每层最后一个节点的值减去最后一个节点的值+1
     *
     * @param root 根节点
     * @return 最大宽度
     */
    public int widthOfBinaryTree(TreeNode root) {
        // 广度优先遍历  相当于层序遍历,然后最后比对每个队列的值
        if (root == null) {
            return 0;
        }
        // 定义队列
        Deque<TreeNode> queue = new LinkedList<>();
        // 队列先加入树节点
        queue.offer(root);
        root.val = 0;
        // 然后遍历这个树
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = Math.max(ans, queue.getLast().val - queue.getFirst().val + 1);

            while (size-- > 0) {
                // 从队列中移除当前节点
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.offer(poll.left);
                    poll.left.val = poll.val * 2;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    poll.right.val = poll.val * 2 + 1;
                }

            }
        }
        return ans;
    }
}
