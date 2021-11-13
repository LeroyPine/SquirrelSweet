package com.squirrel.java.leet.数组.self;

public class 只出现一次的数字 {


    /**
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
