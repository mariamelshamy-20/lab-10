/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sudoku_game;
import exceptions.*;
import java.io.IOException;
/**
 *
 * @author Mariam Elshamy
 */
interface Controlla
{
Catalog getCatalog();
int[][] getGame(char level) throws NotFoundException;
void driveGames(int[][] source) throws SolutionInvalidException;
// A boolean array which says if a specifc cell is correct or invalid
boolean[][] verifyGame(int[][] game);
// contains the cell x, y and solution for each missing cell
int[][] solveGame(int[][] game) throws InvalidGame;
// Logs the user action
void logUserAction(UserAction userAction) throws IOException;
}

