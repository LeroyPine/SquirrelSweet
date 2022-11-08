package com.squirrel.java.algorithm.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luobaosong
 * @date 2022/10/27 22:16
 * @description
 **/
@Slf4j
public class RemoveElement {


    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 4, 6, 6, 8, 8, 8};
        RemoveElement ele = new RemoveElement();
        int result = ele.removeElement(nums, 1);
        log.info("result:{},nums:{}", result, nums);
    }
}
