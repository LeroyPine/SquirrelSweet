package com.squirrel.java.leet.链表.meet;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
 * @date Created in 2021年08月25日 17:31
 * @since 1.0
 */
public class 链表是否有环 {


    /**
     * 链表是否有环:  通过快慢指针,如果有环 快指针一定可以追上他
     *
     * @param head 头
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return true;

    }


    /**
     * @param head
     * @return
     */
    public ListNode hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            if (slow == fast) {
                slow = head;
                fast = fast.next;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();;
        lock.writeLock();
        return null;
    }



    // 环形链表2
    public ListNode hasCycle21(ListNode head) {

        //
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){

            //  追上了、 然后冲新走
            if (slow == fast){
                slow = head;
                fast = fast.next;

                while (slow !=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;

            }
            slow = slow.next;
            fast = fast.next.next;

        }

        return null;
    }


    public boolean hasCycle213(ListNode head) {

        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast ){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }





















}
