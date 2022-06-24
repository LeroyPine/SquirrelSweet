package com.squirrel.java.leet.树.meet;


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


    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 使用队列进行层序遍历
        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        // 如果队列不为空
        while (!queue.isEmpty()) {
            final int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            result.add(list);
        }
        return result;
    }


}
