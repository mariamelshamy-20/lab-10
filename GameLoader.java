/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10;

import java.io.File;

/**
 *
 * @author carol
 */
public class GameLoader {

    private Viewable controller;

    public Loader(Viewable controller) {
        this.controller = controller;
    }

    public Game load(String difficulty) throws NotFoundException {
        return controller.getGame(DifficultyEnum.valueOf(difficulty.toUpperCase()));
    }

    public Game loadIncomplete() throws NotFoundException {
         enforceIncompleteFolderState();
        return controller.getGame(DifficultyEnum.INCOMPLETE);
    }

    public Game loadSolvedBoard(String path) throws SolutionInvalidException {
        return controller.getSolvedGame(path);
    }

    private void enforceIncompleteFolderState() throws IllegalStateException {
        File folder = new File("incomplete");
        File[] files = folder.listFiles();
        if (files == null) {
            return; 
        }
        if (files.length != 0 && files.length != 2) {
            throw new IllegalStateException(
                    "Incomplete folder must be empty or contain exactly 2 files (game + log)."
            );
        }
    }

}
