package com.squirrel.java.leet.数组.self;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {


    // 最长连续子序列。 有几个
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // \
        int ans = 0;

        //
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 从num开始遍历

        int longestNum = 0;
        for (Integer num : set) {

            int curMaxNum = 0;
            // 减少时间复杂度
            // 如果当前元素非连续或者是连续的最小值那么才进入条件
            if (!set.contains(num - 1)) {

                //实际的去记录有几个连续子序列
                int currentNum = num;
                while (set.contains(currentNum)) {
                    currentNum++;
                    curMaxNum++;
                }
                longestNum = Math.max(longestNum, curMaxNum);
            }

        }
        return longestNum;

    }
}
