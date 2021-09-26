package com.squirrel.java.leet.链表.first;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

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
 * @date Created in 2021年04月21日 13:02
 * @since 1.0
 */
@Slf4j
public class 反转链表 {

    public static void main(String[] args) {
        初始化链表 s = new 初始化链表();
        for (int i = 0; i < 4; i++) {
            s.createListNode(i);
        }

        ListNode listNode = reverseList(s.getHead());

        log.info("翻转链表:{}", JSONObject.toJSONString(listNode));

    }


    public static ListNode reverseList(ListNode head) {

        // 012345 NULL   ->  null543210
        /**
         *  将当前节点指向其前一个节点
         */
        // 定义一个新链表

        ListNode prev =  null;
        ListNode curr = head;

        while (curr != null){
            // 将当前节点的指针反转
            ListNode next = curr.next;

            curr.next = prev;
            // 将下一个节点重新指向当前节点
            prev = curr;

            curr = next;
        }
        return prev;
    }
}
