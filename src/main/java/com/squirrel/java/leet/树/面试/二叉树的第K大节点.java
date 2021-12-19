package com.squirrel.java.leet.树.面试;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的第K大节点 {


    /**
     * 思路:
     * 1.二叉树的中序遍历是让元素进行升序的
     * 2.中序遍历存储到一个数组中,然后获取第k大的元素
     *
     * @param root 根节点
     * @param k    k
     * @return k大的元素
     */
    public int kthLargest(TreeNode root, int k) {

        //
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(list.size() - k);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
