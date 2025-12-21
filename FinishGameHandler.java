/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

import java.io.IOException;

/**
 *
 * @author Mariam Elshamy
 */
public class FinishGameHandler {
    public void handleCompletion(int[][] board, char difficulty) throws IOException {
       SequentialValidator validator = new SequentialValidator(board);
       ValidationResult result = validator.validate(board);
        if (result.isValid()) {
            Storage.deleteGame(difficulty);
            Storage.deleteCurrentGame();
            GUI.showMessage("Congratulations! Puzzle solved.");
        } else {
            GUI.showError("Board full but invalid.");
        }
    }
}
