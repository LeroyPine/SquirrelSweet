package com.squirrel.java.algorithm.listnode;

import com.squirrel.java.entity.ListNode;

/**
 * @author luobaosong
 * @date 2022/11/9 11:18
 * @description
 **/
public class ListNodeConstant {


    public static ListNode A_Node = null;
    public static ListNode B_Node = null;

    public static ListNode ONE_NODE = new ListNode(1);
    public static ListNode TWO_NODE = new ListNode(2);
    public static ListNode THREE_NODE = new ListNode(3);
    public static ListNode FOUR_NODE = new ListNode(4);


    public static ListNode FIVE_NODE = new ListNode(5);
    public static ListNode SIX_NODE = new ListNode(6);
    public static ListNode SEVEN_NODE = new ListNode(7);
    public static ListNode EIGHT_NODE = new ListNode(8);

    static {
        ONE_NODE.next = TWO_NODE;
        TWO_NODE.next = THREE_NODE;

        A_Node = ONE_NODE;

        FIVE_NODE.next = SIX_NODE;

        B_Node = FIVE_NODE;

    }

}
