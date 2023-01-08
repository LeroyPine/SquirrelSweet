package com.squirrel.java.algorithm.array;

public class RotateArray {

    /**
     * 旋转数组
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        // 对角线对折
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 在反转每一行
        for (int[] rows : matrix) {
            reverse(rows);
        }

    }

    public void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
