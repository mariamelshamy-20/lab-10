/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;


/**
 *
 * @author Mariam Elshamy
 */
public class FlyweightBoardVerifier {
    public boolean isValid(int[][] board, int[][] positions, int[] values) {
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            board[x][y] = values[i] + 1;
        }

       ValidationResult result = new SequentialValidator(board).validate(board);
       boolean valid = result.state.equals("VALID");


        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            board[x][y] = 0;
        }

        return valid;
    }
}
