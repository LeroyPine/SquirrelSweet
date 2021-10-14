package com.squirrel.java.leet.数组;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;

import static com.squirrel.java.arithmetic.SortAlgorithm.swap;

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

    public static void main(String[] args) {
        final int kthLargest = findKthLargest(new int[]{1, 2, 5, 7, 3, 6}, 3);

        System.out.println(kthLargest);
    }


    public static int findKthLargest(int[] nums, int k) {

        // 倒数第K  快排核心就是  分治法

        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            // 分区索引
            int index = partition(nums, left, right);
            // if index
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }


    }

    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();

        // 随机选取pivot
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            // 进行元素交换  --
            swap(nums, randomIndex, right);
        }
        // 轴距
        int pivot = nums[right];
        //
        int i = left - 1;
        for (int j = left + 1; j <= right - 1; j++) {
            // 如果元素小于轴距
            if (nums[j] < pivot) {
                i++;
                // 进行交换
                swap(nums, i, j);
            }
        }
        // 将pivot 交换到正确位置上
        swap(nums, i + 1, right);

        return i + 1;
    }


}
