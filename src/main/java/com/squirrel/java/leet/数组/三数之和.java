package com.squirrel.java.leet.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * @date Created in 2021年07月16日 19:55
 * @since 1.0
 */
public class 三数之和 {


    public List<List<Integer>> threeSum(int[] nums) {

        // 首先进行排序
        final int n = nums.length;
        Arrays.sort(nums);
        //
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n; first++) {

            // 过滤掉 相邻重复的元素
            if (first > 0 && nums[first] == nums[first + 1]) {
                continue;
            }
            // 第三个元素从右面开始
            int third = n - 1;
            //  由于三数之和为 0 那么 第一个数 =  第2 + 第三 然后取反
            int target = -nums[first];
            // 遍历第二个元素
            for (int second = 0; second < n; second++) {
                // 避免枚举相同的值
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 保证b的指针在c的指针左侧
                while (second < third && second + third > target) {
                    --third;
                }
                // 如果两个指针相遇了 那么跳出
                if (second == third) {
                    break;
                }
                List<Integer> list = new ArrayList<>();
                // 然后枚举
                if (nums[second] + nums[third] == target) {
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
