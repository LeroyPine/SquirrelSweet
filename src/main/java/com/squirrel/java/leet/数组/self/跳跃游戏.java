package com.squirrel.java.leet.数组.self;

public class 跳跃游戏 {

    //[2, 3, 1, 1, 4]
    //[3, 2, 1, 0, 4]
    public boolean canJump(int[] nums) {

        int dist = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            // 判断是否可达到当前下标
            if (i <= dist) {
                //如果可以跳到  然后确认是否可以直接跳到数组最后
                dist = Math.max(dist, i + nums[i]);
                if (dist >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
