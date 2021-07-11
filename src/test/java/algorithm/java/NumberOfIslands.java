package algorithm.java;

import org.junit.jupiter.api.Test;

public class NumberOfIslands {


    @Test
    void testNumIslands() {
        char[][] grid = new char[][]{
                {'0', '0', '1', '1', '0'},
                {'0', '1', '1', '0', '0'},
                {'0', '1', '1', '0', '1'}
        };
        System.out.println(numIslands(grid));
    }

    /**
     * 0 0 1 1 0
     * 0 1 1 0 0
     * 0 1 1 0 1
     */
    public static int numIslands(char[][] grid) {

        int res = 0;

        int n = grid.length;

        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;

        boolean[][] cache = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, cache, i, j, n, m)) {
                    res++;
                }
            }
        }

        return res;

    }

    private static boolean dfs(char[][] grid, boolean[][] cache, int i, int j, int n, int m) {
        if (i >= 0 && j >= 0 &&
                i < n && j < m &&
                grid[i][j] == '1' && !cache[i][j]
        ) {
            cache[i][j] = true;
            dfs(grid, cache, i - 1, j, n, m);
            dfs(grid, cache, i + 1, j, n, m);
            dfs(grid, cache, i, j - 1, n, m);
            dfs(grid, cache, i, j + 1, n, m);
            return true;
        }
        return false;
    }

}
