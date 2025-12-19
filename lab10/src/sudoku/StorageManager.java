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
public class StorageManager {

    private final FolderManager folders = new FolderManager();
    private final GameFileIO fileIO = new GameFileIO();

    public void saveGame(Difficulty level, Game game) {
        try {
            File folder = folders.getDifficultyFolder(level);
            File file = new File(folder, "game_" + System.currentTimeMillis()
                    + ".txt");
            fileIO.writeGame(file, game);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save game", e);
        }
    }

    public void saveCurrentGame(Game game) {
        try {
            File folder = folders.getCurrentFolder();
            clearFolder(folder);
            File file = new File(folder, "current.txt");
            fileIO.writeGame(file, game);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFolder(File folder) {
        for (File f : folder.listFiles()) {
            f.delete();
        }
    }
}
