package com.squirrel.java.theory;

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

        // 统计遍历次数
        int count = 0;
        // 下标
        int index = 0;
        boolean forward = true;

        // 边界： 当遍历次数大于num时,截止
        while (count <= num) {

            if (index == 0) {
                forward = true;
            } else if (index == array.length - 1) {
                forward = false;
            }
            count++;
            // 打印
            System.out.print(array[index]);
            // 控制index
            if (forward) {
                index++;
            } else {
                index--;
            }
        }


    }

}
