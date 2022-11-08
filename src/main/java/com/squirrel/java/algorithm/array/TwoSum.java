package com.squirrel.java.algorithm.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luobaosong
 * @date 2022/11/2 19:45
 * @description
 **/
@Slf4j
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] index = twoSum.twoSum(ArrayConstant.NUM_ARRAY, 50);
        log.info("index:{}", index);
    }
}
