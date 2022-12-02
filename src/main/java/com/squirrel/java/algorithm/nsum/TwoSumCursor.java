package com.squirrel.java.algorithm.nsum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luobaosong
 * @date 2022/11/30 09:39
 * @description
 **/
public class TwoSumCursor {


    public int[] twoSum(int[] nums, int target) {
        // 使用hash表存储下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
