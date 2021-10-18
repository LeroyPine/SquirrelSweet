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
 * @date Created in 2021年06月26日 18:00
 * @since 1.0
 */
public class 二叉树的右视图 {
    /**
     * 层序遍历？
     */

    public List<Integer> levelOrder(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            list.add(queue.peek().val);
            final int size = queue.size();

            for (int i = 0; i <size; i++) {

                final TreeNode poll = queue.poll();
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                if (poll.left!=null){
                    queue.add(poll.left);
                }

            }

        }
        return list;

    }
}
