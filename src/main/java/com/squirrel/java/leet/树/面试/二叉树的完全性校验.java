package com.squirrel.java.leet.树.面试;

import java.util.*;

public class 二叉树的完全性校验 {


    public boolean isCompleteTree(TreeNode root) {
        // root
        if (root == null) {
            return false;
        }

        List<Anode> nodes = new ArrayList<>();
        nodes.add(new Anode(root, 1));

        int i = 0;
        while (i < nodes.size()) {
            Anode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new Anode(anode.node.left, anode.code * 2));
                nodes.add(new Anode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i - 1).code == nodes.size();
    }


    public class Anode {
        TreeNode node;
        int code;

        public Anode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }


    public boolean isCompleteTree1(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while((node = queue.poll()) != null) {
            queue.offer(node.left);
            queue.offer(node.right);
        }

        for(TreeNode n : queue) {
            if(n != null)
                return false;
        }
        return true;


    }
}
