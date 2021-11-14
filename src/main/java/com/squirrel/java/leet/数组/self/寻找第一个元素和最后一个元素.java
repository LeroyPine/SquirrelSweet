package com.squirrel.java.leet.数组.self;

public class 寻找第一个元素和最后一个元素 {


    public int[] searchRange(int[] arr, int target) {


        int low = searchLeft(arr, target);
        int high = searchRight(arr, target);

        if (low>high){
            return new int[]{-1,-1};
        }
        return new int[]{low, high};

    }

    private int searchLeft(int[] arr, int target) {
       int left = 0;
       int right = arr.length-1;

       while (left<=right){

           int mid = left +(right-left)/2;
           if (target<=arr[mid]){
               right = mid-1;
           }else {
               left = mid+1;
           }
       }
       return left;

    }

    private int searchRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果中间索引的值小于目标值， 那么指针向左移动一位
            if (target >= arr[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return right;
    }
}
