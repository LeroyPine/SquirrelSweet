package com.squirrel.java.leet.数组;

import java.util.ArrayList;
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


    /**
     * 思路:
     * 1.递归-选择了一个数,在没有选择的数下面继续进行选择
     * 2.设计状态变量:标记元素是否被选取过
     *
     * @param nums 数组
     * @return 结果集
     */
    public List<List<Integer>> permute(int[] nums) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        // 每一组元素
        List<Integer> path = new ArrayList<>();
        // 元素个数
        final int length = nums.length;
        if (length == 0) {
            return res;
        }
        // 状态变量
        boolean[] used = new boolean[length];
        // 回溯 - 原数组,数组长度，
        backtrack(nums, length, 0, path, used, res);
        return res;

    }

    /**
     * 具体回溯方法
     *
     * @param nums  数组
     * @param len   数组长度
     * @param depth 遍历深度
     * @param path  选择路径
     * @param used  是否走过此路径
     * @param res   结果集
     */
    private void backtrack(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 如果没有选择过当前元素
            if (!used[i]) {
                // 状态变量标记,证明当前元素已选择
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, len, depth+1, path, used, res);
                // 状态变量重置,标记当前元
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
