package com.squirrel.java.leet.链表.meet;

public class 复制带随机指针的链表 {

    public ListNode copyRandomList(ListNode head) {

        // todo
        return null;


    }


    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }
}
