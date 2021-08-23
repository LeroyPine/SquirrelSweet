package com.squirrel.java.leet.链表;

import com.sun.org.apache.regexp.internal.RE;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年04月13日 15:53
 * @since 1.0
 */
public class 两数相加 {

    public static void main(String[] args) {
        // init
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);


        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        listNode8.next = listNode9;

        ListNode listNode15 = new ListNode(9);
     /*   ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(3);


        listNode5.next = listNode6;
        listNode6.next = listNode7;

        1 3 0 3 4
        9 9 9 1 0
*/


      /*  System.out.println("链表长度为:" + getLength(listNode));
        System.out.println("该链表得到的数为:" + getNum(listNode));*/
        System.out.println("两数相加:" + addTwoNumbersSelf(listNode, listNode15));
    }


    /**
     * 两个数量相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            // 进位
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


    public static int getNum(ListNode listNode) {
        int temp = listNode.val;
        int mul = 10;
        int i = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            double pow = Math.pow(mul, i);
            temp = (int) (temp + listNode.val * pow);
            i++;
        }

        return temp;
    }

    // 获取a的长度

    public static int getLength(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }
        int i = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            i++;
        }
        return i;
    }


    /**
     * 两数量相加
     * <p>
     * 6 2 3 4
     * 4 5 6
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersSelf(ListNode l1, ListNode l2) {

        // 为空补0
        ListNode tempA = l1;
        ListNode tempB = l2;
        ListNode resultNode = new ListNode(-1);
        ListNode outNode = resultNode;
        int carry = 0;

        while (tempA != null || tempB != null) {
            // 定义相加的参数
            int numA = tempA != null ? tempA.val : 0;
            int numB = tempB != null ? tempB.val : 0;

            int result = (numA + numB + carry) % 10;
            carry = (numA + numB + carry) / 10;
            outNode.next = new ListNode(result);
            outNode = outNode.next;
            if (tempA != null) {
                tempA = tempA.next;
            }
            if (tempB != null) {
                tempB = tempB.next;
            }
        }
        if (carry > 0) {
            outNode.next = new ListNode(carry);
        }
        return resultNode.next;

    }


    public ListNode addTwoNumbersV3(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;

        ListNode resultNode = new ListNode(-1);
        ListNode dummyNode = resultNode;
        int result = 0;

        while (l1 != null || l2 != null) {

            // 如果为空赋值为0
            int l1Num = l1 != null ? l1.val : 0;
            int l2Num = l2 != null ? l2.val : 0;

            //
            result = (l1Num + l2Num + carry) % 10;
            carry = (l1Num + l2Num + carry) / 10;

            dummyNode.next = new ListNode(result);
            dummyNode = dummyNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            dummyNode.next = new ListNode(carry);
        }


        return resultNode.next;

    }


}
