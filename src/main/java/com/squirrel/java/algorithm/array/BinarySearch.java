package com.squirrel.java.algorithm.array;

import lombok.extern.slf4j.Slf4j;

/**
 * 二分查找
 *
 * @author luobaosong
 * @date 2022/10/31 16:03
 * @description
 **/
@Slf4j
public class BinarySearch {

    /**
     * 搜索
     *
     * @param array  数组
     * @param target 目标
     * @return int
     */
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                right--;
            } else if (array[mid] > target) {
                left++;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(ArrayConstant.NUM_ARRAY, 8);
        log.info("search:{}", search);
    }

}
