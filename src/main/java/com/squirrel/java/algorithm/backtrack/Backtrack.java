package com.squirrel.java.algorithm.backtrack;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯
 *
 * @author luobaosong
 * @date 2022/11/14 10:37
 * @description
 **/
@Slf4j
public class Backtrack {


    public static void main(String[] args) {
        Backtrack backtrack = new Backtrack();
        List<List<Integer>> permute = backtrack.permute(new int[]{1, 2, 3});
        log.info(JSON.toJSONString(permute));
    }

    /**
     * 算法框架:
     * result = []
     * def backtrack(路径, 选择列表):
     * if 满足结束条件:
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表:
     * 做选择
     * backtrack(路径, 选择列表)
     * 撤销选择
     * <p>
     * <p>
     * // : 核心就是for循环里面的递归,在递归调用之前做选择,在递归调用之后撤销选择
     */

    List<List<Integer>> res = new LinkedList<>();


    public List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        //「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];
        // 回溯
        backtrack(nums, track, used);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 回溯终止条件,加满一个集合
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
    // 回溯法就是纯暴力穷举 复杂度一般都很高
}
