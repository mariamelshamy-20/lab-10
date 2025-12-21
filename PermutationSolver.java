package sudoku_game;

import exceptions.InvalidGame;

public class PermutationSolver {

    public int[][] solveGame(int[][] board) throws InvalidGame {
        return new Solver().solveGame(board);
    }
}
