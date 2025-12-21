/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

import exceptions.InvalidGame;
import java.util.*;

/**
 *
 * @author Mariam Elshamy
 */
public class Solver {
    public int[][] solveGame(int[][] board) throws InvalidGame {
        int[][] positions = findEmptyCells(board);
        if (positions.length != 5) throw new InvalidGame("Must have exactly 5 empty cells");

        PermutationIterator iterator = new PermutationIterator(positions);
        FlyweightBoardVerifier verifier = new FlyweightBoardVerifier();

        while (iterator.hasNext()) {
            int[] values = iterator.next();
            if (verifier.isValid(board, positions, values)) {
                int[][] solution = new int[positions.length][3];
                for (int i = 0; i < positions.length; i++) {
                    solution[i][0] = positions[i][0];
                    solution[i][1] = positions[i][1];
                    solution[i][2] = values[i] + 1;
                }
                return solution;
            }
        }

        throw new InvalidGame("No valid solution found");
    }

    private int[][] findEmptyCells(int[][] board) {
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == 0) empty.add(new int[]{i, j});
        return empty.toArray(new int[0][]);
    }
}
