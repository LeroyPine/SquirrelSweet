package com.squirrel.java.leet.数组;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年09月22日 18:21
 * @since 1.0
 */
public class 搜索旋转数组 {

    // 使用二分查找
    public int search(int[] nums, int target) {

        // 切分成两段
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        // 切分成两段有序的数组
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 选取中位数
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 分段查询
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
