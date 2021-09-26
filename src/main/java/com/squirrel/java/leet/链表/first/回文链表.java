package com.squirrel.java.leet.链表.first;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 *
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年04月23日 13:02
 * @since 1.0
 */
public class 回文链表 {

    public boolean isPalindrome(ListNode head) {

        // 可以用栈来实现

        Deque<Integer> stack = new LinkedList<>();
        ListNode temp1 = head;
        while (temp1 != null) {
            stack.push(temp1.val);
            temp1 = temp1.next;
        }
        ListNode temp2 = head;
        while (temp2 != null) {
            if (temp2.val != (stack.pop())) {
                return false;
            }
            temp2 = temp2.next;
        }
        return true;
    }

    // 基于数组的复制
    public boolean isPalindromeV2(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        final boolean palindromeV3 = isPalindromeV3(node);
    }


    public static boolean isPalindromeV3(ListNode head) {

        ListNode temp = head;

        ListNode reverseNode = reverse(temp);

        System.out.printf("翻转:" + reverseNode);
  // 1211 //1121

        while (head != null) {
            if (reverseNode == null) {
                return false;
            }

            if (head.val != reverseNode.val) {
                return false;
            } else {
                head = head.next;
                reverseNode = reverseNode.next;
            }
        }
        return true;
    }

    public static ListNode reverse(ListNode node) {

        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }


}