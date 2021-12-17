package com.squirrel.java.leet.数组;

import java.util.HashSet;
import java.util.Set;

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
 * @date Created in 2021年09月28日 16:08
 * @since 1.0
 */
public class 最长连续序列 {

    /**
     * 题目:
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param nums 数组
     * @return 最长连续序列的值
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 通过Set集合的方式来实现
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //
        int longStep = 0;
        // 通过set集合进行筛选连续子序列
        for (int num : set) {
            // 当前元素
            int currentNum = num;
            int currentStep = 0;
            // 过滤掉之前统计过的数-- 连续的序列一次性通过while统计完毕
            if (!set.contains(currentNum - 1)) {
                while (set.contains(currentNum)) {
                    currentNum = currentNum + 1;
                    currentStep++;
                }
            }
            longStep = Math.max(longStep, currentStep);
        }
        return longStep;
    }

}
