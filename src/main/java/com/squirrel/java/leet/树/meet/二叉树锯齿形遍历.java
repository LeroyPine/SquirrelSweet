package com.squirrel.java.leet.树.面试;

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
 * @date Created in 2021年09月17日 10:27
 * @since 1.0
 */
public class 二叉树锯齿形遍历 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // 层序遍历使用队列
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;

        // 如果队列不为空
        while (!queue.isEmpty()) {

            final int size = queue.size();
            //
            Deque<Integer> nodeValues = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                if (isLeft) {
                    nodeValues.offerLast(node.val);
                } else {
                    nodeValues.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            isLeft = !isLeft;
            ArrayList<Integer> skr = new ArrayList<>(nodeValues);
            list.add(skr);
            // 出队列
        }
        return list;
    }

}
