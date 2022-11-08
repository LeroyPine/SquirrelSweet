package com.squirrel.java.algorithm.array;

import lombok.extern.slf4j.Slf4j;

/**
 * 删除零
 *
 * @author luobaosong
 * @date 2022/10/28 11:48
 * @description
 **/
@Slf4j
public class RemoveZero {


    /**
     * 给你输入一个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾
     *
     * @param nums 全国矿工工会
     */
    public void moveZeroes(int[] nums) {
        // 删除0,最后把剩余的数组置为0
        if (nums == null) {
            return;
        }
        RemoveElement removeElement = new RemoveElement();
        int len = removeElement.removeElement(nums, 0);
        for (; len < nums.length; len++) {
            nums[len] = 0;
        }
    }

    public static void main(String[] args) {
        RemoveZero removeZero = new RemoveZero();
        int[] nums = new int[]{1, 1, 0, 0, 6, 6, 8, 8, 8};
        removeZero.moveZeroes(nums);
        log.info("nums:{}", nums);
    }
}
