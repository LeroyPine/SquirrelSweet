package com.squirrel.java.leet.树;

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
 * @date Created in 2021年06月25日 13:49
 * @since 1.0
 */
public class 二叉树中序遍历 {


    /**
     * 思路:
     * 1.深度优先遍历
     * 2.左根右,先添加左节点、根节点、右节点
     *
     * @param root 根节点
     * @return re
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * 思路:
     * 1.利用栈这个数据结构
     * 2.将左节点进行一顿压栈
     * 3.然后出栈,并加入右节点
     *
     * @param root 根节点
     * @return 中序遍历值
     */
    public List<Integer> postorderTraversalWhile(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // 根节点不为空或者栈不为空
        while (root != null || !stack.isEmpty()) {
            // 将左节点进行压栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 左节点出栈
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;
    }

}
