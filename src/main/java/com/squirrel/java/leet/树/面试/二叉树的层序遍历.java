package com.squirrel.java.leet.树.面试;


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
 * @date Created in 2021年07月16日 11:31
 * @since 1.0
 */
public class 二叉树的层序遍历 {


    public List<List<Integer>> levelOrderSelf(TreeNode root) {

        // 一层 ::: 采用队列
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> nodes = new LinkedList<>();

            while (size-- > 0) {
                final TreeNode poll = queue.poll();

                assert poll != null;
                nodes.add(poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            list.add(nodes);

        }

        return list;

    }


    // 层序遍历

    public List<List<Integer>> levelOrderSelf1(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 使用队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> re = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                re.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(re);

        }
        return result;
    }


}
