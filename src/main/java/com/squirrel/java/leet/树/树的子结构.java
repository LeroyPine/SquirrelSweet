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
 * @date Created in 2021年06月25日 17:36
 * @since 1.0
 */
public class 树的子结构 {


    public boolean isSubStruct(TreeNode A, TreeNode B) {

        // 是否为树的子结构

        /**
         * 1. 判断是否存在 B是否属于A的节点
         * 2. 遍历 A的左子树和右子树
         * 3. B 可能是以 根节点为A的子树  也可能是 A的左子树 或者 B的右子树
         */

        if (A == null || B == null) {
            return false;
        }

        // 判断是否是子树
        return sub(A, B) || isSubStruct(A.left, B) || isSubStruct(A.right, B);

    }

        public boolean sub(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }
            if (a == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }
            return sub(a.left, b.left) && sub(a.right, b.right);
        }

    public static void main(String[] args) {


        System.out.println();
    }


}
