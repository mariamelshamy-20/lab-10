package sudoku_game;

import exceptions.*;

public class ControllerFacade {

    private final Controllable controller;

    public ControllerFacade(Controllable controller) {
        this.controller = controller;
    }

    /* ---------- GAME LOADING ---------- */
    public int[][] loadGame(char level) {
        try {
            return controller.getGame(level);
        } catch (NotFoundException e) {
            GUI.showError("Game not found");
        }
        return null;
    }

    /* ---------- GAME VERIFICATION ---------- */
    public boolean[][] verifyBoard(int[][] board) {
        return controller.verifyGame(board);
    }

    /* ---------- SOLVER ---------- */
    public int[][] solveGame(int[][] board) {
        try {
            return controller.solveGame(board);
        } catch (InvalidGame e) {
            GUI.showError(e.getMessage());
        }
        return null;
    }

    /* ---------- LOGGING ---------- */
    public void logAction(UserAction action) {
        try {
            controller.logUserAction(action);
        } catch (Exception e) {
            GUI.showError("Logging failed");
        }
    }
}
