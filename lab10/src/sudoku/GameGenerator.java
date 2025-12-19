/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.List;

/**
 *
 * @author Miriam
 */
public class GameGenerator {

    public Game generate(Game solvedGame, Difficulty level) {
        int removals = getRemovalCount(level);
        int[][] board = solvedGame.board; // IMPORTANT: reference, not copy
        RandomPairs randomPairs = new RandomPairs();
        List<int[]> cells = randomPairs.generateDistinctPairs(removals);
        for (int[] cell : cells) {
            int row = cell[0];
            int col = cell[1];
            board[row][col] = 0; // remove value
        }
        return new Game(board);
    }

    private int getRemovalCount(Difficulty level) {
        switch (level) {
            case EASY:
                return 10;
            case MEDIUM:
                return 20;
            case HARD:
                return 25;
            default:
                throw new IllegalArgumentException("Unknown difficulty");
        }
    }
}
