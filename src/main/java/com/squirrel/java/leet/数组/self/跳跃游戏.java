package com.squirrel.java.leet.数组.self;

public class 跳跃游戏 {

    //[2, 3, 1, 1, 4]
    //[3, 2, 1, 0, 4]
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int dist = 0;
        for (int i = 0; i < nums.length; i++) {
            // 能到达的最远位置
            dist = Math.max(dist, i + nums[i]);
            if (dist >= len - 1) {
                return true;
            }
        }
        return false;

    }
}
