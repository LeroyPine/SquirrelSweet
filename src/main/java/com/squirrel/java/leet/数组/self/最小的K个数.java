package com.squirrel.java.leet.数组.self;

public class 最小的K个数 {


    /**
     * 普通排序
     *
     * @param nums
     * @return
     */
    public int[] getK(int[] nums, int k) {
        popSort(nums);
        int[] small = new int[k];
        for (int i = 0; i < k; i++) {
            small[i] = nums[i];
        }
        return nums;
    }


    public void popSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }

        }
    }
}
