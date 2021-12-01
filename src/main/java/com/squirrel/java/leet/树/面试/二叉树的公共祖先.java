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
 * @date Created in 2021年09月22日 20:05
 * @since 1.0
 */
public class 二叉树的公共祖先 {

    // 公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root != null) {
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

            if (leftNode != null && rightNode != null) {
                return root;
            } else if (leftNode == null) {
                return rightNode;
            } else {
                return leftNode;
            }
        }
        return null;
    }

}
