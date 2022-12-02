package com.squirrel.java.algorithm.nsum;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luobaosong
 * @date 2022/11/30 09:43
 * @description
 **/
@Slf4j
public class NSum {

    public static void main(String[] args) {
        NSum nSum = new NSum();
        List<List<Integer>> res = nSum.twoSum(new int[]{3, 5, 6, 2, 5, 1, 7, 0, 8}, 0, 8);
        log.info("Nsum twoSum res:{}", JSON.toJSONString(res));

        List<List<Integer>> threeSum = nSum.threeSum(new int[]{3, 5, 6, 2, 5, 1, 7, 0, 8}, 8);
        log.info("Nsum threeSum res:{}", JSON.toJSONString(threeSum));
    }


    /**
     * 两树之和 并跳过重复的元素
     *
     * @param nums   全国矿工工会
     * @param target 目标
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> twoSum(int[] nums, int left, int target) {
        // 将数组进行排序,找出所有构成 target 的元素,并不重复
        Arrays.sort(nums);
        int right = nums.length - 1;

        List<List<Integer>> res = new ArrayList<>();

        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum == target) {
                List<Integer> singleRes = new ArrayList<>();
                singleRes.add(leftNum);
                singleRes.add(rightNum);
                res.add(singleRes);
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == leftNum) {
                    left++;
                }

            } else if (sum > target) {
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            }
        }
        return res;
    }


    /**
     * 三数之和
     * <p>
     * 由两树之和 遍历而来
     *
     * @param nums   全国矿工工会
     * @param target 目标
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            // 两数之和
            int twoSum = target - nums[i];
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, twoSum);
            for (List<Integer> twoSumRe : twoSumRes) {
                twoSumRe.add(nums[i]);
                res.add(twoSumRe);
            }
            // 过滤掉i i+1相同的情况
            while (i < nums.length - 1 && nums[i + 1] == temp) {
                i += 1;
            }
        }
        return res;
    }

}
