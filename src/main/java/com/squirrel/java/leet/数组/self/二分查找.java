package com.squirrel.java.leet.数组.self;

public class 二分查找 {


    /**
     * 普通的二分查找  有序数组
     * @param arr
     * @param target
     * @return
     */
    public int getIndex(int[] arr,int target){

        int left = 0;
        int right = arr.length-1;

        while (left<=right){

            int mid = left + (right-left)/2;

            if (arr[mid] == target){
                return mid;
            }else if (arr[mid]> target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        二分查找 er = new 二分查找();
        int index = er.getIndex(new int[]{1, 2, 5, 6, 8}, 7);  //4
        System.out.println(index);
    }

}
