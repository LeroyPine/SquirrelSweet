package com.squirrel.java.leet.链表.meet;

import java.util.HashMap;

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
 * @date Created in 2021年09月26日 17:59
 * @since 1.0
 */
public class 缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {

            if (!map.containsKey(i)) {
                return i;
            }

        }
        return -1;
    }
}
