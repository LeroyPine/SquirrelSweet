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
 * @date Created in 2021年09月26日 09:48
 * @since 1.0
 */
public class 岛屿数量 {

    /**
     * 思路:
     * 1.寻找到岛屿
     * 2.深度遍历直到找到水,将某一块小岛全部置为0
     * 3.然后再去寻找下一个小岛
     *
     * @param grid 网格
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // asd
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    dfs(grid, i, j, nr, nc);
                }
            }
        }
        return num_islands;
    }


    /**
     * 深度遍历dfs
     *
     * @param grid 网格
     * @param r    row
     * @param c    col
     * @param nr   nr
     * @param nc   nc
     */
    private void dfs(char[][] grid, int r, int c, int nr, int nc) {
        // 边界条件判断 -- || --
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c, nr, nc);
        dfs(grid, r - 1, c, nr, nc);
        dfs(grid, r, c + 1, nr, nc);
        dfs(grid, r, c - 1, nr, nr);
    }


}
