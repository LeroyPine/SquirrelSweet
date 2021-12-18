package com.squirrel.java.leet.链表.meet;

public class 二叉树与双向链表 {


    /**
     * 思路:
     * 1. 递归终止条件:节点为null
     * 2. 递归左子树,即dfs(cur.left)
     * 3. 构件链表:
     * 1.当pre为空时,代表正在访问链表头节点
     * 2.当pre不为空的时候,修改双向节点引用。
     * 3.
     *
     * @param root 根节点
     * @return 链表
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        // 头尾节点互相指向
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 定义头尾节点
    Node pre = null, head = null;

    /**
     * @param root
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        // 中序遍历最左侧,为根节点
        dfs(root.left);
        if (pre == null) {
            head = root;
        } else {
            // 链表组合
            pre.right = root;
        }
        root.left = pre;
        // pre一直移动
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
