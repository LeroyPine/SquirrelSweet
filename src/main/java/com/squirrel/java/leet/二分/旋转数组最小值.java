package com.squirrel.java.leet.二分;

public class 旋转数组最小值 {


    public int findMin(int[] nums) {

        int low =0;
        int high = nums.length-1;
        while (low<high){

            int pivot = low + (high-low)/2;
            if (nums[pivot]<nums[high]){
                high = pivot;
            }else {
                low = pivot+1;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        旋转数组最小值 啊= new 旋转数组最小值();
        int min = 啊.findMin(new int[]{3, 4, 5, 1, 2});

        System.out.println(min);
    }
}
