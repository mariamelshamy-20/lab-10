/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author Mariam Elshamy
 */
public class PermutationIterator implements Iterator {
    private final int[][] positions;
    private final int[] current;
    private boolean hasNext = true;

    public PermutationIterator(int[][] positions) {
        this.positions = positions;
        this.current = new int[positions.length];
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
    @Override
    public int[] next() {
        if (!hasNext) throw new NoSuchElementException();
        int[] result = current.clone();
        advance();
        return result;
    }

    private void advance() {
        for (int i = current.length - 1; i >= 0; i--) {
            if (current[i] < 8) {
                current[i]++;
                for (int j = i + 1; j < current.length; j++) current[j] = 0;
                return;
            }
        }
        hasNext = false;
    }
}
