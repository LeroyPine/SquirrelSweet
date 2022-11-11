package com.squirrel.java.algorithm.listnode;

import com.squirrel.java.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luobaosong
 * @date 2022/11/9 11:15
 * @description
 **/
@Slf4j
public class IntersectionNode {

    /**
     * 得到交叉节点
     *
     * @param headA 头疼
     * @param headB headb
     * @return {@link ListNode}
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }
            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return p;
    }


    public static void main(String[] args) {

        ListNode node = getIntersectionNode(ListNodeConstant.A_Node, ListNodeConstant.B_Node);

        log.info("node:{}", node);

    }
}
