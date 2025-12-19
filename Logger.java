/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

/**
 *
 * @author Mariam Elshamy
 */
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Logger {
    private final File logFile;

    public Logger(File logFile) {
        this.logFile = logFile;
    }

    public void logUserAction(UserAction action) throws IOException {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write(action.toString() + "\n");
        }
    }

    public UserAction undoLastAction() throws IOException {
        List<String> lines = Files.readAllLines(logFile.toPath());
        if (lines.isEmpty()) return null;

        String last = lines.remove(lines.size() - 1);
        Files.write(logFile.toPath(), lines);
        return UserAction.fromString(last);
    }
}
