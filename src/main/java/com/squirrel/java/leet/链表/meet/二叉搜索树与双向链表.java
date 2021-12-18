package com.squirrel.java.leet.链表.meet;

public class 二叉搜索树与双向链表 {


    Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * @param root
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        // 中序遍历
        dfs(root.left);
        if (pre == null) {
            // 标记为头结点
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        // 然后去访问右节点
        pre = root;
        dfs(root.right);
    }


    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
