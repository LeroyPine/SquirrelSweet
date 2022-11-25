package com.squirrel.java.algorithm.bfs;

import com.squirrel.java.entity.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 寻求最小高度
 *
 * @author luobaosong
 * @date 2022/11/20 20:41
 * @description
 **/
@Slf4j
public class SeekMinimumHeight {


    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(3, null, null);

        TreeNode treeNode1 = new TreeNode(2, null, treeNode2);

        TreeNode treeNode = new TreeNode(1, null, treeNode1);

        int depth = minDepth(treeNode);

        log.info("depth:{}", depth);
    }


    /**
     * 最小深度
     * DFS
     *
     * @param root 根
     * @return int
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDep = minDepth(root.left);
        int rightDep = minDepth(root.right);

        return (leftDep == 0 || rightDep == 0) ? leftDep + rightDep + 1 : Math.min(leftDep, rightDep) + 1;
    }


    public static int minDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
