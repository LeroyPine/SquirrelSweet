package com.squirrel.java.algorithm.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 *
 * @author luobaosong
 * @date 2022/10/27 11:44
 * @description
 **/
@Slf4j
public class RemoveDuplicatesItem {


    /**
     * 快慢指针原地删除
     *
     * @param nums 全国矿工工会
     * @return int
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 4, 6, 6, 8, 8, 8};
        RemoveDuplicatesItem item = new RemoveDuplicatesItem();
        int size = item.removeDuplicates(nums);
        log.info("nums:{},size:{}", nums, size);
        int[] limitNums = Arrays.stream(nums).limit(size).toArray();
        log.info("limitNums:{}", limitNums);
    }
}
