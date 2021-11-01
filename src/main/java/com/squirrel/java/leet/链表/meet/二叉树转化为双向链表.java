package com.squirrel.java.leet.链表.meet;

import org.w3c.dom.Node;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉树转化为双向链表 {


    Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return root;
        }
        dfs(root);
        head.left = pre;
        pre.right =head;
        return head;
    }

    private void dfs(Node root) {

        // 递归终止条件
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre!=null){
            pre.right = root;
        }else {
            head = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
        return;


    }


    class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
