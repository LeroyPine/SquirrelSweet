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


    /**
     * 思路：依次枚举,第一个数选中,
     * 然后 第二个数和第三个数采用双指针的方式进行比较
     * 最终取得最终的值。
     *
     * @param nums 数组
     * @return 三个数的合集
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 首先将数组进行排序
        int len = nums.length;
        Arrays.sort(nums);
        // 定义结果集
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            //过滤掉重复的数据
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 选取第三个数
            int third = len - 1;
            // 因为三数之和为0,所以
            int target = -nums[first];
            // 然后去枚举 第二个数和第三个数之和为target的
            for (int second = first + 1; second < len; second++) {
                //如果第二个数和第一个数相同 直接过滤
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 控制右指针
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

}
