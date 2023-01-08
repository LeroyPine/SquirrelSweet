package com.squirrel.java.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 控制4个边界
        int row = matrix.length;
        int col = matrix[0].length;
        //
        int leftBound = 0;
        int uppderBound = 0;
        int rightBound = col - 1;
        int downBound = row - 1;
        List<Integer> result = new ArrayList<>();
        int size = row * col;

        while (result.size() < size) {
            // println
            if (uppderBound <= downBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    result.add(matrix[uppderBound][j]);
                }
                uppderBound++;
            }

            if (rightBound >= leftBound) {
                for (int i = uppderBound; i <= downBound; i++) {
                    result.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            if (downBound >= uppderBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    result.add(matrix[downBound][j]);
                }
                downBound--;
            }

            if (leftBound <= rightBound) {
                for (int i = downBound; i >= uppderBound; i--) {
                    result.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }

        return result;


    }
}
