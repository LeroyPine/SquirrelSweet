package com.squirrel.java.leet.数组.self;

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
 * @date Created in 2021年06月03日 10:13
 * @since 1.0
 */
public class 两数之和 {

    /**
     * 思路:
     * <p>
     * 将数组中的每一个数存入hash表中  并判断 目标值-当前值是否等于要算的数
     *
     * @param nums   数组
     * @param target 目标值
     * @return 结果集
     */
    public int[] twoSum(int[] nums, int target) {
        //使用map存储下标
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return new int[]{0};
    }

}
