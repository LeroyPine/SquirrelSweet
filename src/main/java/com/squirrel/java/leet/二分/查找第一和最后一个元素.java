package com.squirrel.java.leet.二分;

public class 查找第一和最后一个元素 {


    //https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/

    public int[] searchRange(int[] nums, int target) {

        int leftIndex =binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false)-1;

        if (leftIndex <= rightIndex&& rightIndex<nums.length&&nums[leftIndex] ==target
        && nums[rightIndex] ==target)
        {
            return new int[]{leftIndex,rightIndex};
        }else {
            return new int[]{-1,-1};
        }



    }


    public int binarySearch(int[] nums,int target,boolean lower){
        int left = 0;
        int right = nums.length-1;
        int ans  = nums.length;

        while (left<=right){

            int mid = (left + right)/2;
            if (nums[mid] > target || (lower && nums[mid] >=target) ){
                right = mid-1;
                ans = mid;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }
}
