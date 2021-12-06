package com.squirrel.java.leet.二分;

public class 寻找有序数组的中位数 {

    /*
      **终于说服自己**


      使用二分法直接在两个数组中找中位数分割线，使得nums1和nums2中分割线满足以下性质即可根据分割线左右的数来确定中位数：

      前置：m = nums1.length，n = nums2.length。设i为nums1中分割线，则取值为[0, m]，表示分割线左侧元素下标为[0, i-1]，分割线右侧元素下标为[i, m-1]；设j为nums2中分割线，....。

      m+n为偶数： i + j = (m + n )/2 ，为奇数：i + j = (m + n)/2 + 1。

      分割线左侧元素小于等于分割线右侧元素。由于两个数组均为正序数组，则只需要要求：nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]；
      * [0, m]中找到最大的i使得nums1[i-1] <= nums2[j]，因此可以使用二分查找。（证明：假设我们已经找到了满足条件的最大i，使得nums1[i-1] <= nums2[j]，
      * 那么此时必有nums[i] > nums2[j]，进而有nums[i] > nums2[j-1]）

      分割线找到后，若m+n为奇数，分割线左侧的最大值即为中位数；若为偶数，分割线左侧的最大值与分割线右侧的最小值的平均数即为中位数。时间复杂度：O(log(min(m, n)))，空间复杂度：O(1)
   */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 始终保证nums1为较短的数组，nums1过长可能导致j为负数而越界
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            int m = nums1.length;
            int n = nums2.length;

            // m+n 为奇数，分割线要求左侧有 (m+n)/2 + 1 个元素
            // m+n 为偶数，分割线要求左侧有 (m+n)/2     个元素
            // 两种情况其实可以统一写作 (m+n+1)/2，表示对(m+n)/2向上取整
            // 对整数来说，向上取整等于：(被除数 + (除数 - 1)) / 除数
            // 也可以使用Math类中提供的库函数

            // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
            int totalLeft = (m + n + 1) / 2;

            // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
            // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
            int left = 0;
            int right = m;


            while (left < right) {
                // +1 向上取整避免 left + 1 = right 时可能无法继续缩小区间而陷入死循环
                int i = left + (right - left + 1) / 2;
                int j = totalLeft - i;

                //要找最大i，使得nums1[i-1] <= nums2[j]
                //使用对立面缩小区间
                if (nums1[i - 1] > nums2[j]) {
                    // [i+1, m]均不满足
                    right = i - 1;
                } else {
                    // i满足说明[0, i-1]均不为满足条件的最大i，舍去以缩小区间
                    left = i;
                }
            }

            //退出循环时left=right，表示最终nums1中分割线的位置
            int i = left;
            //nums2中分割线的位置
            int j = totalLeft - left;

            //判断极端情况
            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];  //nums1分割线左边没有元素
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];  //nums2分割线左边没有元素
            int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];     //nums1分割线右边没有元素
            int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];     //nums2分割线右边没有元素

            if ((m + n) % 2 == 0) {
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } else {
                return Math.max(nums1LeftMax, nums2LeftMax);
            }
        }
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 保证 nums1 一直比nums2短
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        //

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            // 向上取整
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;

            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - left;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 证明为偶数
        if ((m + n) % 2 == 0) {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }


    }

}

