package com.squirrel.java.leet.树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
 * @date Created in 2021年06月26日 18:00
 * @since 1.0
 */
public class 二叉树的右视图 {
    /**
     * 层序遍历？
     */

    public List<Integer> levelOrder(TreeNode root) {

        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return temp;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (root.left != null) {
                    queue.offer(node.left);
                }
                if (root.right != null) {
                    queue.offer(node.right);
                }
            }
            if (queue.peek() != null) {
                temp.add(queue.peek().val);

            }
        }
        return temp;

    }
}
