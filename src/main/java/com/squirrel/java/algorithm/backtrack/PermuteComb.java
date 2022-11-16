package com.squirrel.java.algorithm.backtrack;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 排列组合相关回溯算法
 *
 * @author luobaosong
 * @date 2022/11/15 22:43
 * @description
 **/
@Slf4j
public class PermuteComb {

    public static void main(String[] args) {

        PermuteComb permuteComb = new PermuteComb();

        List<List<Integer>> subsets = permuteComb.subsets(new int[]{1, 2, 3});
        log.info(JSON.toJSONString(subsets));

        List<List<Integer>> combine = permuteComb.combine(3, 2);
        log.info(JSON.toJSONString(combine));

        List<List<Integer>> subsetsWithDup = permuteComb.subsetsWithDup(new int[]{1, 2, 2});
        log.info(JSON.toJSONString(subsetsWithDup));

        List<List<Integer>> combinationSum2 = permuteComb.combinationSum2(new int[]{10, 5, 5, 7, 8}, 20);
        log.info(JSON.toJSONString(combinationSum2));

    }


    /**
     * 获取所有子集
     *
     * @param nums num
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 回溯获取子集
        subSetsBacktrack(nums, 0, track, res);
        return res;
    }

    private void subSetsBacktrack(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        // 加入子节点
        res.add(new LinkedList<>(track));
        // 用start为下标 限制递归
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 回溯
            subSetsBacktrack(nums, i + 1, track, res);
            // 撤销选择
            track.removeLast();
        }
    }


    /**
     * 组合, 1到n  k个数的组合
     * <p>
     * // 可选择元素为 1---n
     * // 可选择元素的数量 为K个
     *
     * @param n n
     * @param k k
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        combineBacktrack(res, track, n, k, 1);
        return res;
    }

    private void combineBacktrack(List<List<Integer>> res, LinkedList<Integer> track, int n, int k, int start) {
        // 如果路径大小集合为k
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 排除不合法的选择
            track.addLast(i);
            combineBacktrack(res, track, n, k, i + 1);
            track.removeLast();
        }
    }


    /**
     * 子集  不允许重复
     *
     * @param nums 全国矿工工会
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        subsetsWithDupBacktrack(nums, 0, res, track);
        return res;
    }

    private void subsetsWithDupBacktrack(int[] nums, int start, List<List<Integer>> res, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        // 选择列表
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            subsetsWithDupBacktrack(nums, i + 1, res, track);
            track.removeLast();
        }
    }


    /**
     * 组合总数
     *
     * @param candidates 候选人
     * @param target     目标
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Integer trackSum = 0;
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        combinationSumBacktrack(candidates, target, 0, trackSum, res, track);
        return res;
    }

    private void combinationSumBacktrack(int[] candidates, int target, int startIndex, Integer trackSum, List<List<Integer>> res, LinkedList<Integer> track) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        // 选择列表
        for (int i = 0; i < candidates.length; i++) {
            // 不允许重复,那么需要剪枝
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            trackSum += candidates[i];
            track.addLast(candidates[i]);
            combinationSumBacktrack(candidates, target, i + 1, trackSum, res, track);
            trackSum -= candidates[i];
            track.removeLast();
        }
    }
}
