package com.squirrel.java.leet.树;

import java.util.*;

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
 * @date Created in 2021年06月26日 15:41
 * @since 1.0
 */
public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Integer queueSize = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {

                TreeNode node = queue.poll();
                sub.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(sub);
        }
        return list;
    }

    /**
     * 3
     * 5   6
     *
     * @param root
     * @return
     */


    public List<List<Integer>> levelOrderSelf(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // 先进先出的双端队列
        if (root == null) {
            return result;
        }

        Deque<TreeNode> que = new ArrayDeque<>();
        // 加入到队列
        que.offer(root);

        while (!que.isEmpty()) {

            List<Integer> cList = new ArrayList<>();

            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();

                cList.add(poll.val);
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }

            }

            result.add(cList);

        }
        return result;

    }


}
