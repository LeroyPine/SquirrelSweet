package com.squirrel.java.leet.数组.finals;

/**
 * @author luobaosong
 * @date 2022/8/19 18:44
 * @description
 **/
public class SearchHeadTailIndex {

    public static int[] defaultIndex = {-1, -1};

    /**
     * nums = [5,7,7,8,8,10], target = 8 [3,4]
     */

    public int[] getHeadTail(int[] array, int target) {
        // 采取什么方法寻找?  二分法
        if (array == null || array.length == 0) {
            return defaultIndex;
        }
        int left = 0;
        int right = array.length - 1;
        int headIndex = -1;
        int rightIndex = -1;

        while (left < right) {

            int mid = (left + right) / 2;
            if (target == array[mid]) {
                headIndex = mid;
                rightIndex = mid;
            }else {

            }


        }


        return null;
    }


}
