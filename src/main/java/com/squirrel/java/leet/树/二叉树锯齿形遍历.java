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
 * @date Created in 2021年08月03日 15:09
 * @since 1.0
 */
public class 二叉树锯齿形遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 标记每层
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 使用双端队列
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeft = true;

        while (!queue.isEmpty()) {
            // 每次循环代表一层   先左后右 控制添加队列的顺序
            final int size = queue.size();
            Deque<Integer> sub = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                final TreeNode poll = queue.poll();
                if (isLeft) {
                    sub.offerLast(poll.val);
                } else {
                    sub.offerFirst(poll.val);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
            isLeft = !isLeft;
            result.add(new LinkedList<>(sub));
        }
        return result;
    }
}
