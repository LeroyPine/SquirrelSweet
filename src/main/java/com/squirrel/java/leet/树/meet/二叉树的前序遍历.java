package com.squirrel.java.leet.树.meet;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {


    /**
     * 二叉树的前序 ：：     根左右
     *
     * @param root
     * @return
     */

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        preOrder(list, root);

        return list;
    }

    private void preOrder(List<Integer> list, TreeNode root) {

        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(list,root.left);
        preOrder(list, root.right);

    }


}
