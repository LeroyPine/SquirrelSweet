package com.squirrel.java.leet.数组;

import java.util.ArrayList;
import java.util.List;

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
 * @date Created in 2021年09月23日 15:59
 * @since 1.0
 */
public class 螺旋矩阵 {

    // 螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {

        //
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        // 行
        int rows = matrix.length;
        // 列
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = rows - 1;
        //
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    /**
     * 螺旋矩阵   一层一层往里遍历
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int top = 0;

        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;


        while (left <= right && top <= bottom) {

            // 上面的行
            for (int col = left; col <= right; col++) {
                list.add(matrix[top][col]);
            }
            //  右面的列
            for (int row = top + 1; row <= bottom; row++) {
                list.add(matrix[row][right]);
            }
            //
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    list.add(matrix[bottom][col]);
                }

                for (int row = bottom; row > top; row--) {
                    list.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return list;

    }
}
