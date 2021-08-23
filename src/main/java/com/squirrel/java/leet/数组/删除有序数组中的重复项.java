package com.squirrel.java.leet.数组;

import java.util.ServiceLoader;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

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
 * @date Created in 2021年06月02日 15:56
 * @since 1.0
 */
public class 删除有序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {
        ReentrantLock lock =new ReentrantLock();
        lock.lock();
        //   原地删除
        int cnt = 0, n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ++cnt;
                System.out.println(nums[i]);
            } else {
                nums[i - cnt] = nums[i];
                //System.out.println(nums[i]);
            }
        }
        System.out.println(nums);
        return n - cnt;
    }


    //  数组相关： 定义标识：
    public static int removeDuplicatesMin2(int[] nums) {

        //   原地删除
        int cnt = 0, n = nums.length;
        int cur = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ++cnt;

            } else {
                cnt = 0;
            }
            if (cnt < 2) {
                nums[cur++] = nums[i];
                System.out.println(nums[i]);
            }
        }
        return cur;
    }

    public static void main(String[] args) {

      /*  int array[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(array);
        System.out.println(i);*/

        int arr[] = new int[]{0,0,1,1,1,1,2,3,3};

        int i1 = removeDuplicatesMin2(arr);
        System.out.println(i1);

    }
}
