package com.squirrel.java.leet.树.面试;

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
 * @date Created in 2021年09月28日 16:46
 * @since 1.0
 */
public class 翻转二叉树 {


    /**
     * 思路:
     * 1. 深度优先遍历 访问每个节点,每个节点的左右子节点直接进行反转即可。
     *
     * @param root 根节点
     * @return 翻转后的二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
