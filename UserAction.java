/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

/**
 *
 * @author Mariam Elshamy
 */
public class UserAction {
    public final int x, y, val, prev;

    public UserAction(int x, int y, int val, int prev) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + val + "," + prev;
    }

    public static UserAction fromString(String line) {
        String[] parts = line.split(",");
        return new UserAction(
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]),
            Integer.parseInt(parts[3])
        );
    }
}

