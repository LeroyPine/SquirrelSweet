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
public class 二叉树的最大路径之和 {

    int maxSum = Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {

        // 递归获取每个节点的贡献值
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 获取左右节点的值
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        int result = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, result);

        return root.val + Math.max(leftGain, rightGain);


    }


    public int maxPathSum1(TreeNode root) {

        maxGain1(root);

        return maxSum;

    }


    private static int maxSum1 = 0;
    private static int maxGain1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain1(root.left), 0);
        int rightGain = Math.max(maxGain1(root.right), 0);

        int result = root.val + leftGain + rightGain;

        maxSum1 = Math.max(maxSum1, result);

        return root.val + Math.max(leftGain, rightGain);

    }

    public static void main(String[] args) {
        maxGain1(new TreeNode(5));
    }
}
