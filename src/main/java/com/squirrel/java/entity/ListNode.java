package com.squirrel.java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * @date Created in 2021年04月02日 10:53
 * @since 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;


    public ListNode(Integer val) {
        this.val = val;
    }


    public static ListNode init() {
        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        ListNode threeNode = new ListNode(3);
        ListNode fourNode = new ListNode(4);
        oneNode.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        return oneNode;
    }

}
