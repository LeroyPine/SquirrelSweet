package com.squirrel.java.leet.数组;

public class 多数元素 {


    /**
     * 思路:
     * 1.投票算法
     *
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += candidate == nums[i] ? 1 : -1;
        }

        return candidate;
    }


}
