package com.squirrel.java.leet.树.meet;

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
 * @date Created in 2021年09月28日 14:58
 * @since 1.0
 */
public class 对称二叉树 {

    /**
     * 思路:
     * 1.递归的调用左右子树,并判对称的节点的值是否相同
     * 2.以及是否存在是否一个为null 一个不为null
     *
     * @param root 根节点
     * @return 树是否是对称的
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {

        // 都为null则是对称的
        if (p == null && q == null) {
            return true;
        }
        // 存在一个不为null
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
