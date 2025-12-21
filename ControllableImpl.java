/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

import exceptions.InvalidGame;
import java.io.IOException;

/**
 *
 * @author Mariam Elshamy
 */
public class ControllableImpl implements Controllable {
    private final GameManager manager;

    public ControllableImpl(GameManager manager) {
        this.manager = manager;
    }

    public Catalog getCatalog() {
        return manager.getCatalog();
    }

    public int[][] getGame(char level) throws NotFoundException {
        return manager.loadGame(level);
    }

    public void driveGames(int[][] source) throws SolutionInvalidException {
        manager.generateGames(source);
    }

    public boolean[][] verifyGame(int[][] game) {
        return manager.verifyBoard(game);
    }

    public int[][] solveGame(int[][] game) throws InvalidGame {
        return new Solver().solveGame(game);
    }

    public void logUserAction(UserAction action) throws IOException {
        new Logger(manager.getLogFile()).logUserAction(action);
    }
}

