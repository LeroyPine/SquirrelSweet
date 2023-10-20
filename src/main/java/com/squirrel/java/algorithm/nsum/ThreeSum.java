package com.squirrel.java.algorithm.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 三数之和,不重复,首先将数组进行排序,以便于和的计算
        Arrays.sort(nums);
        // 数组长度
        int length = nums.length;
        // 结果集
        List<List<Integer>> result = new ArrayList<>();
        // 选中第一个数,之后在寻找其他两数之和
        for (int first = 0; first < length; first++) {
            // 忽略值重复的元素
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            // 再次寻找两数之和为target的
            int third = length - 1;
            for (int second = first + 1; second < length; second++) {
                // 忽略值重复的元素
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 保证 second 一直保持在 third之前
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> subResult =  new ArrayList<>();
                    subResult.add(nums[first]);
                    subResult.add(nums[second]);
                    subResult.add(nums[third]);
                    result.add(subResult);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }


}
