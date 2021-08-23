package com.squirrel.java.leet.树;

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
 * @date Created in 2021年06月26日 14:38
 * @since 1.0
 */
public class 翻转二叉树 {

    /**
     * 翻转
     *
     * @param root
     * @return 1
     * 2      3
     * 1   3   3  4
     * <p>
     * 从上往下交换 左右节点
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        // 左右节点交换
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
