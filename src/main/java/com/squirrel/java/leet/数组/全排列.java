package com.squirrel.java.leet.数组;

import javax.management.relation.InvalidRelationTypeException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
 * @date Created in 2021年09月24日 16:44
 * @since 1.0
 */
public class 全排列 {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        // 元素个数
        final int n = nums.length;
        // 回溯
        backtrack(n, output, res, 0);
        return res;

    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // first 第一
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {

            Collections.swap(output, first, i);
            // 递归填下一个数
            backtrack(n, output, res, first + 1);
            // 交换
            Collections.swap(output, first, i);


        }

    }

}
