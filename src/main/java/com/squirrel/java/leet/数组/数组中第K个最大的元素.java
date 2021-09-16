package com.squirrel.java.leet.数组;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
 * @date Created in 2021年09月10日 19:08
 * @since 1.0
 */
public class 数组中第K个最大的元素 {

/*

    public int findKthLargest(int[] nums, int k) {

        // 排序
        Arrays.sort(nums);
        // set 集合
        Set<Integer> set = new HashSet();
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (j == k) {
                return nums[i];
            }
            j++;
        }
        return -1;

    }

    Random random = new Random();

    // 快速排序 第K大元素
    public int findKthLargestQuick(int[] nums, int k) {

        // 快排查询
        return quickSelect(nums, 0, nums.length - 1, k);

    }

    public int quickSelect(int[] nums, int left, int right, int index) {

        // 随机选取pivot
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }

    }

    public int randomPartition(int[] nums, int left, int right) {
        final int p = random.nextInt(nums[right - left + 1]);
        // 交换基准值
        swap(nums, p, right);
        // partition
        return partition(nums, left, right);

    }

    private int partition(int[] nums, int left, int right) {
        int target = nums[right];
        int i = left - 1;
        for (int j = left; j < right - left; j++) {
            if (nums[i] <= target) {
                swap(nums, i++, right);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }


    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    //  查找数组中第K个元素

    public int findKthLargestV2(int[] nums, int k) {
        return quickSelectV2(nums, 0, nums.length - 1, nums.length - k);
    }


    private int quickSelectV2(int[] nums, int left, int right, int index) {
        // 随机选取一个 pivot
        int pivot = selectRandomPartition(nums, left, right);
        //
        if (pivot == index) {
            return nums[pivot];
        } else {
            return pivot < index ? quickSelectV2(nums, 0, pivot - 1, index) :

                    quickSelectV2(nums, pivot + 1, right, index);
        }
    }

    private int selectRandomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1);
        // 交换基准值
        swapV2(nums, i, right);
        return partitionV2(nums, left, right);
    }

    private int partitionV2(int[] nums, int left, int right) {
        int target = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] < target) {
                swapV2(nums, i, j);
                i++;
            }
        }
        // 调整基准值
        swapV2(nums, i, right);
        return i;
    }

    private void swapV2(int[] nums, int i, int right) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
    }
*/


    class Solution {
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        /*private int quickSelect(int[] nums, int left, int right, int index) {
            // 随机一个树
            int pivot = random.nextInt(right - left + 1) + left;
            swap(nums,pivot,right);
            // 排序
            return partition(nums,left,right);
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
*/
      public int quickSelect(int[] a, int left, int right, int index) {
            int q = randomPartition(a, left, right);
            if (q == index) {
                return a[q];
            } else {
                return q < index ? quickSelect(a, q + 1, right, index) : quickSelect(a, left, q - 1, index);
            }
        }

        public int randomPartition(int[] a, int left, int right) {
            int i = random.nextInt(right - left + 1) + left;
            swap(a, i, right);
            return partition(a, left, right);
        }

        public int partition(int[] a, int left, int right) {
            int x = a[right], i = left;
            for (int j = left; j < right; ++j) {
                if (a[j] <= x) {
                    swap(a, i, j);
                    i++;
                }
            }
            swap(a, i, right);
            return i;
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }



}
