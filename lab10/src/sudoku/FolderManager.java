/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author DELL
 */
import java.io.File;

public class FolderManager {

    private static final String ROOT = "games";

    public File getDifficultyFolder(Difficulty level) {
        File folder = new File(ROOT + "/" + level.name().toLowerCase());
        folder.mkdirs();
        return folder;
    }

    public File getCurrentFolder() {
        File folder = new File(ROOT + "/current");
        folder.mkdirs();
        return folder;
    }
}
