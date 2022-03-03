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
 * @date Created in 2021年09月28日 14:43
 * @since 1.0
 */
public class 根节点到叶子节点的数字之和 {


    /**
     * 思路:
     * 1.递归,递归的时候将计算父节点的值传入到叶子节点
     * 2.判断叶子节点的方式
     *
     * @param root 根节点
     * @return 根节点到叶子节点数字之和
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }
        prevSum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return prevSum;
        }
        return dfs(root.left, prevSum) + dfs(root.right, prevSum);
    }
}
