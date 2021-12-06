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

        // 使用头插法
        ListNode headNode = new ListNode(-1);

        while (head != null) {
            ListNode next = head.next;
            head.next = headNode.next;
            headNode.next = head;
            head = next;
        }
        return headNode;
    }
}
