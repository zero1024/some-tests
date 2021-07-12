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

        if (grid.length == 0) {
            return 0;
        }

        boolean[][] cache = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, cache, i, j)) {
                    res++;
                }
            }
        }

        return res;

    }

    private static boolean dfs(char[][] grid, boolean[][] cache, int i, int j) {
        if (i >= 0 && j >= 0 &&
                i < grid.length && j < grid[0].length &&
                grid[i][j] == '1' && !cache[i][j]
        ) {
            cache[i][j] = true;
            dfs(grid, cache, i - 1, j);
            dfs(grid, cache, i + 1, j);
            dfs(grid, cache, i, j - 1);
            dfs(grid, cache, i, j + 1);
            return true;
        }
        return false;
    }

}
