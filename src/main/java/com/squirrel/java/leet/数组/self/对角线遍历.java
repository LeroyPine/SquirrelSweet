package com.squirrel.java.leet.数组.self;

public class 对角线遍历 {


    public static int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[] answer = new int[rowLen * colLen];
        int count = rowLen + colLen - 1;

        int m = 0;
        int n = 0;
        int answerIndex = 0;

        for (int i = 0; i < count; i++) {

            if (i % 2 == 0) {
                while (m >= 0 && n < colLen) {
                    answer[answerIndex] = matrix[m][n];
                    answerIndex++;
                    m--;
                    n++;
                }
                if (n < colLen) {
                    m++;
                } else {
                    m = m + 2;
                    n--;
                }
            } else {
                while (m < rowLen && n >= 0) {
                    answer[answerIndex] = matrix[m][n];
                    answerIndex++;
                    m++;
                    n--;
                }
                if (m < rowLen) {
                    n++;
                } else {
                    m--;
                    n = n + 2;
                }

            }
        }
        return answer;

    }

}
