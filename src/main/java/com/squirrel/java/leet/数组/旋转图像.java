package com.squirrel.java.leet.数组;


public class 旋转图像 {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int [][] matrix_new = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                matrix_new[j][n-i-1] = matrix[i][j];
                
            }

        }

        // 然后进行copy

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix_new[i][j];
            }

        }
    }
}
