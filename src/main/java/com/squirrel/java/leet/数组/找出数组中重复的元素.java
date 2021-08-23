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
 * @date Created in 2021年05月14日 09:35
 * @since 1.0
 */
public class 找出数组中重复的元素 {


    public static void main(String[] args) {

        int nums[] = new int[]{29, 30, 30, 32, 34, 44, 45, 46, 47,46};
        System.out.println(printDuplicateItem(nums));
    }

    /**
     * 数组中重复的元素
     * <p>
     * 1,2,2,3,4,4,6,7,6
     * 2,4,6
     *
     * @param nums
     */
    public static int printDuplicateItem(int[] nums) {

        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt > mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }


}
