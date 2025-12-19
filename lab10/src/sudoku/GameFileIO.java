/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.io.*;

/**
 *
 * @author Miriam
 */
public class GameFileIO {

    public void writeGame(File file, Game game) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    writer.write(game.board[i][j] + " ");
                }
                writer.newLine();
            }
        }
    }

    public Game readGame(File file) throws IOException {
        int[][] board = new int[9][9];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < 9; i++) {
                String[] tokens = reader.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(tokens[j]);
                }
            }
        }
        return new Game(board);
    }
}
