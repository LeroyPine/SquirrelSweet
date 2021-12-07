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

    /**
     * 思路：锯齿形遍历
     * 1.主要是添加元素的时候可以增加一个变量
     * 2.这个变量用于反转添加元素的顺序
     *
     *  Z字型遍历
     *  -------
     *     -
     *    -
     *  -------
     * @param root 根节点
     * @return re
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 定义一个变量,用来进行添加元素时反转
        boolean orderLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 通过一个队列来反转元素
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 变向,添加结点的时候区分左右
                if (orderLeft) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            orderLeft = !orderLeft;
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
