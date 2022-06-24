package com.squirrel.java.leet.树.meet;

import java.util.Deque;
import java.util.LinkedList;

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
 * @date Created in 2021年09月27日 11:02
 * @since 1.0
 */
public class 从前序与中序遍历构造树 {

    /**
     * 思路:
     * 1.前序遍历的第一个节点为根节点
     * 2.中序遍历的左子树节点都在根节点左侧,右子树都在根节点右侧
     * 3.可以分别对左子树以及右子树进行构造
     * 我们用一个栈和一个指针辅助进行二叉树的构造。初始时栈中存放了根节点（前序遍历的第一个节点），指针指向中序遍历的第一个节点；
     * 我们依次枚举前序遍历中除了第一个节点以外的每个节点。如果 index 恰好指向栈顶节点，那么我们不断地弹出栈顶节点并向右移动 index，并将当前节点作为最后一个弹出的节点的右儿子；如果 index 和栈顶节点不同，我们将当前节点作为栈顶节点的左儿子；
     * 无论是哪一种情况，我们最后都将当前的节点入栈。
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 校验数组的有效性
        if (preorder == null || inorder == null) {
            return null;
        }
        // 找到根节点
        TreeNode root = new TreeNode(preorder[0]);
        // 定义栈
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // 中序遍历索引
        int inOrderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            // 前序遍历的值
            int preOrderVal = preorder[i];
            // 判断栈中的值
            TreeNode node = stack.peek();
            // 并与中序遍历的索引值进行比较
            if (node.val != inorder[inOrderIndex]) {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex]) {
                    node = stack.pop();
                    inOrderIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
