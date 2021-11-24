package com.squirrel.java.leet.数组.self;

public class 下一个排列 {


    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            this.swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);

    }

    public void swap(int array[], int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }


    public void reverse(int[] nums, int start, int end) {

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
