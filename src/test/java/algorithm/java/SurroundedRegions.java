package algorithm.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SurroundedRegions {

    @Test
    void testSolve1() {
        char[][] grid = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    @Test
    void testSolve2() {
        char[][] grid = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solve(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            mark(board, i, 0);
        }
        for (int i = 0; i < board.length; i++) {
            mark(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
            mark(board, 0, j);
        }
        for (int j = 0; j < board[0].length; j++) {
            mark(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void mark(char[][] board, int i, int j) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = 'T';
            mark(board, i - 1, j);
            mark(board, i + 1, j);
            mark(board, i, j - 1);
            mark(board, i, j + 1);
        }

    }

}
