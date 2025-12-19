/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;
import java.io.*;
import java.util.*;

/**
 *
 * @author Miriam
 */

//Pupose of class: board + metadata + serialization helpers (to/from CSV file).
//Design pattern followed: DTO/data container: clean separation between model & logic

public class Game {
    // IMPORTANT: board must be kept by REFERENCE (PDF requirement)
    public final int[][] board;

    /**
     * Constructs a Game using an existing board reference.
     * DO NOT deep-copy the board.
     */
    public Game(int[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }
        if (board.length != 9) {
            throw new IllegalArgumentException("Board must have 9 rows");
        }
        for (int i = 0; i < 9; i++) {
            if (board[i] == null || board[i].length != 9) {
                throw new IllegalArgumentException("Each row must have 9 columns");
            }
        }
        this.board = board;
    }

    /**
     * Counts the number of empty cells (zeros).
     */
    public int countEmptyCells() {
        int count = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Returns true if the board is completely filled (no zeros).
     */
    public boolean isComplete() {
        return countEmptyCells() == 0;
    }

    /**
     * Sets a value in the board.
     * Used by GUI, solver, and undo system.
     */
    public void setCell(int row, int col, int value) {
        validateIndices(row, col);
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Cell value must be between 0 and 9");
        }
        board[row][col] = value;
    }

    /**
     * Gets a value from the board.
     */
    public int getCell(int row, int col) {
        validateIndices(row, col);
        return board[row][col];
    }

    private void validateIndices(int row, int col) {
        if (row < 0 || row >= 9 || col < 0 || col >= 9) {
            throw new IndexOutOfBoundsException("Row and column must be in range 0..8");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(board[r][c]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game other = (Game) o;
        return board == other.board; // reference equality (intentional)
    }

    @Override
    public int hashCode() {
        return Objects.hash(System.identityHashCode(board));
    }
}
