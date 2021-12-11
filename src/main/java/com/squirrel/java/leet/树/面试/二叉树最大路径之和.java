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
 * @date Created in 2021年09月26日 10:45
 * @since 1.0
 */
public class 二叉树最大路径之和 {


    /**
     * 思路:
     * 1.求出左右子树的最大贡献值
     * 2.注意点, 用Math.max()选取左右节点的最大值
     * 3.为何要筛选左右节点最大值呢?因为路径的选择可能包含了左节点或者右节点
     *
     * @param root 根节点
     * @return 路径之和
     */
    public int maxPathSum(TreeNode root) {
        // 递归获取每个节点的贡献值
        maxGain(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    private int maxGain(TreeNode root) {
        // 递归结束条件
        if (root == null) {
            return 0;
        }
        // 收集左右子树的值
        int leftVal = Math.max(maxGain(root.left), 0);
        int rightVal = Math.max(maxGain(root.right), 0);
        // 路径之和
        int result = leftVal + rightVal + root.val;
        // 选取最大的路径
        maxSum = Math.max(maxSum, result);

        return root.val + Math.max(leftVal, rightVal);
    }
}
