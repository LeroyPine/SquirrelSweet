package com.squirrel.java.leet.数组.self;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {


    // 最长连续子序列。
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // \
        int ans = 0;

        // 去遍历集合看最长子序列有多少》
        for (int num : numSet) {
            // 如果当前元素没有比他小的序列那么就进入方法
            int currentNum = num;
            int maxNum = 0;
            if (!numSet.contains(num - 1)) {
                while (numSet.contains(currentNum)) {
                    currentNum++;
                    maxNum++;
                }
                ans = Math.max(maxNum, ans);
            }

        }
        return ans;

    }
}
