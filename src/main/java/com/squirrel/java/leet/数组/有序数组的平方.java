package com.squirrel.java.leet.数组;

public class 有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        // 迭代一次比较 加入到数组的第一个
        int[] sortNums = new int[nums.length];

        for (int i = 0, j = nums.length - 1, pos = nums.length - 1; i <= j; ) {

            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                sortNums[pos] = nums[i] * nums[i];
                i++;
            } else {
                sortNums[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return sortNums;
    }
}
