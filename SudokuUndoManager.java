package lab10;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SudokuUndoManager {
    private final File logFile;

    public SudokuUndoManager(File logFile) {
        this.logFile = logFile;
    }

    public void recordMove(Game game, int row, int col, int oldValue, int newValue) {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write("(" + row + "," + col + "," + newValue + "," + oldValue + ")\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void undo(Game game) {
        try {
            List<String> lines = Files.readAllLines(logFile.toPath());
            if (!lines.isEmpty()) {
                String last = lines.get(lines.size() - 1);
                String[] parts = last.replace("(", "").replace(")", "").split(",");
                int row = Integer.parseInt(parts[0].trim());
                int col = Integer.parseInt(parts[1].trim());
                int prev = Integer.parseInt(parts[3].trim());
                game.setValue(row, col, prev);
                lines.remove(lines.size() - 1);
                Files.write(logFile.toPath(), lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        try {
            if (logFile.exists()) {
                Files.write(logFile.toPath(), new byte[0]); // clear file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
