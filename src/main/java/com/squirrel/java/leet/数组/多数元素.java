package com.squirrel.java.leet.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 多数元素 {


    // 大于数组一般的元素。
    public int majorityElement(int[] nums) {


        int len = nums.length;
        if(len <2){
            return nums[0];
        }
        // 集合
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                map.put(num, integer + 1);
            } else {
                map.put(num, 1);
            }
        }
        //7
        // 遍历map
        int middle = len/2 +1;

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= middle ){
                ans = entry.getKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        多数元素 a = new 多数元素();
        a.majorityElement(new int[]{-1,-1,2147483647});

    }
}
