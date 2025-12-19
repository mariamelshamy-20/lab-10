package sudoku;

public class GameDriver {

    private final SudokuValidator validator;
    private final GameGenerator generator;
    private final StorageManager storage;

    public GameDriver(SudokuValidator validator) {
        this.validator = validator;
        this.generator = new GameGenerator();
        this.storage = new StorageManager();
    }

    public void driveGames(Game sourceGame) throws SolutionInvalidException {

        // 1️⃣ Validate the source solution (DO NOT TRUST INPUT)
        ValidationResult result = validator.validate(sourceGame.board);

        // 2️⃣ Reject INVALID or INCOMPLETE solutions (Lab requirement)
        if (!result.valid || result.incomplete) {
            throw new SolutionInvalidException(
                "Provided Sudoku solution is invalid or incomplete."
            );
        }

        // 3️⃣ Generate and store all difficulty levels at once
        for (Difficulty level : Difficulty.values()) {
            Game generated = generator.generate(sourceGame, level);
            storage.saveGame(level, generated);
        }
    }
}
