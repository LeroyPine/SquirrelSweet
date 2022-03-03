package com.squirrel.java.leet.树.面试;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月23日 11:06
 * @since 1.0
 */
public class 二叉树的右视图 {
    // 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            list.add(queue.peek().val);
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode poll = queue.poll();
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
            }
        }
        return list;

    }


    // 二叉树的右视图  -- 从右面看
    public List<Integer> rightSideView2(TreeNode root) {

        // 二叉树的层序遍历如何遍历呢？  使用队列的方式
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 如果队列不为空  那么让他遍历起来
        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode peek = queue.peek();
            list.add(peek.val);
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
        }
        return list;

    }
}
