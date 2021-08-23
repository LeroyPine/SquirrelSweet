package com.squirrel.java.leet.链表;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

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
 * @date Created in 2021年04月02日 16:26
 * @since 1.0
 */
@Slf4j
public class 两数之和 {

//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。


    public static void main(String[] args) {
        int a[] = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(a, 9);

        log.info("【两数之和：{}】", ints);

        int[] ints1 = twoSumHash(a, 9);
        log.info("【hash两数之和：{}】", ints);
    }

    /**
     * 暴力解法 ： 遍历每个元素与不是他的元素进行相加
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] a = {0};
        if (nums == null) {
            return a;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1;
            while (j > i)
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                } else {
                    j = j - 1;
                }

        }
        return a;

    }

    // 使用hash
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // 一次遍历
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);

        }
        return new int[]{0};
    }
}
