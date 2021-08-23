package com.squirrel.java.leet.链表.meet;

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
 * @date Created in 2021年04月02日 10:53
 * @since 1.0
 */
@Data
@Builder
public class ListNode {

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
