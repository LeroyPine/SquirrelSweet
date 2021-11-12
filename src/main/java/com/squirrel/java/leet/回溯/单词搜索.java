package com.squirrel.java.leet.回溯;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 单词搜索 {


    public boolean exist(char[][] board, String word) {

        int high = board.length;  //数组长度
        int width = board[0].length;
        // 记录访问过的位置
        boolean[][] visited = new boolean[high][width];

        for (int i = 0; i < high; i++) {

            for (int j = 0; j < width; j++) {

                // 挨个元素去跑
                boolean check = check(board, visited, i, j, word, 0);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }


    // 校验单词能否被搜索到

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int idx) {

        if (board[i][j] != word.charAt(idx)) {
            // 如果某个位置的字符不等于当前字符串的值  直接返回false
            return false;
        } else if (idx == word.length() - 1) {
            // 证明最后一个字符相同
            return true;
        }
        // 已经走到的节点
        visited[i][j] = true;
        //  定义方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;

        for (int[] direction : directions) {
            // 新坐标
            int newi = i + direction[0], newj = j + direction[1];
            // 判断新坐标是否在有效的边界中
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 如果没访问过
                if (!visited[newi][newj]) {
                    boolean check = check(board, visited, newi, newj, word, idx + 1);
                    if (check) {
                        result = true;
                        break;
                    }

                }
            }
        }
        visited[i][j] = false;
        return result;


    }


}
