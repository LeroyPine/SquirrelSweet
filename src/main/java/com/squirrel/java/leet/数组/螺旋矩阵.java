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
     * 螺旋矩阵:掌握好各个边界
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        while (top <= bottom && left <= right) {
            // 最上层
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }
            // 最右层
            for (int rown = top + 1; rown <= bottom; rown++) {
                res.add(matrix[rown][right]);
            }
            // 下以及左
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]);
                }
                for (int rown = bottom; rown > top; rown--) {
                    res.add(matrix[rown][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;

        }
        return res;


    }


}
