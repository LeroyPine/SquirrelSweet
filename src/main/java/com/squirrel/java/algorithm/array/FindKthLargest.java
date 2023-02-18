package com.squirrel.java.algorithm.array;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest kthLargest = new FindKthLargest();
        int kthLargest1 = kthLargest.findKthLargest(new int[]{1, 3, 4, 6, 3}, 4);
        System.out.println(kthLargest1);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 0) {
            return -1;
        }


        // 优先队列？
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

}
