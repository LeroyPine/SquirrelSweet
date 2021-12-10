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

    /**
     * 思路:
     * 螺旋矩阵:掌握好各个边界
     *
     * @param matrix 矩阵
     * @return 矩阵集合结果
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 结果集Res
        List<Integer> res = new ArrayList<>();
        // 校验二维数组是否是合理的
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        // result =-=-=-=-=-=-=-=-=
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        // 循环停止条件-左到右  上到下
        while (left <= right && top <= bottom) {
            // 行
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            // 列
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                // 右往左
                for (int col = right - 1; col > left; col--) {
                    res.add(matrix[bottom][col]);
                }
                // 底向上
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }


}
