package com.squirrel.java.leet.数组.self;

public class 寻找旋转排序数组的最小值 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 请找出其中最小的元素。
     * <p>
     * 你可以假设数组中不存在重复元素。
     * <p>
     * 示例1:
     * <p>
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * <p>
     * 示例2:
     * <p>
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     * <p>
     * 旋转终点   i
     * <p>
     * 0 ，i    i  arr.len -1
     */

    public int minValue(int[] arr) {
        //https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-00kj/
        // 二分查找
        int left = 0;
        int right = arr.length - 1;
        int minValue = Integer.MAX_VALUE;

        /*while (left <= right) {

            int mid = (right + left) / 2;

            if (arr[left] <= arr[mid]){
                minValue = Math.min(arr[left],minValue);
            }else {

            }   }
*/

        return 0;
    }

}
