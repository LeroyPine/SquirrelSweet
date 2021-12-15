package com.squirrel.java.leet.数组;

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
 * @date Created in 2021年05月08日 11:06
 * @since 1.0
 */
public class 数组遍历N次 {



    public static void main(String[] args) {

        int array[] = new int[]{1, 3, 4, 5};

        printArray(array, 8);


    }


    /**
     * 打印数组 n 次
     * 到头就反向
     * 定义标识： 是否反向
     *
     * @param array
     * @param num
     */
    public static void printArray(int[] array, int num) {

        int count = 0;
        int index = 0;
        boolean forward = false;

        while (count < num) {

            if (index == array.length - 1) {
                forward = false;
            } else if (index == 0) {
                forward = true;
            }
            System.out.println(array[index]);
            if (forward) {
                index++;
            } else {
                index--;
            }

            count++;
        }

    }

}
