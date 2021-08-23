package com.squirrel.java.ref;

import lombok.Builder;
import lombok.Data;

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
 * @date Created in 2021年05月13日 10:21
 * @since 1.0
 */
public class ReferenceClass {


    public static void main(String[] args) {

        ListNode head;

        ListNode dummy = new ListNode(1);

        head = dummy;
        head.next = new ListNode(2);
        head.next = new ListNode(3);
        head = head.next;
        System.out.println(dummy);


    }


    @Data
    @Builder
    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(Integer val) {
            this.val = val;
        }

        ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
