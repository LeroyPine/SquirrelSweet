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
 * @date Created in 2021年07月05日 17:34
 * @since 1.0
 */
public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {


        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int mindep = Integer.MAX_VALUE;
        if (root.left != null) {
            mindep = Math.min(minDepth(root.left), mindep);
        }
        if (root.right != null) {
            mindep = Math.min(minDepth(root.right), mindep);
        }
        return mindep + 1;

    }
}
