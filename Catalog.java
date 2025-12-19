package lab10;

import java.io.File;

public class Catalog {

    private boolean current;
    private boolean allModesExist;

    public Catalog() {
        File currentFolder = new File("current");
        File[] currentFiles = currentFolder.listFiles();
        if (currentFiles != null) {
            current = (currentFiles.length == 0 || currentFiles.length == 2);
        } else {
            current = false;
        }

        File easy = new File("easy");
        File medium = new File("medium");
        File hard = new File("hard");
        allModesExist = easy.exists() && medium.exists() && hard.exists();
    }

    public boolean isCurrentValid() {
        return current;
    }

    public boolean doAllModesExist() {
        return allModesExist;
    }
}
