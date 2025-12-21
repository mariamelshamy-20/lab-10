/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateError {

    public String type;  
    public int index;     
    public int number;    
    public Set<Integer> positions;

    public DuplicateError(String type, int index, int number) {
        this.type = type;
        this.index = index+1;
        this.number = number;
        this.positions= new LinkedHashSet<>();
    }

    public void addPosition(int i) {
        positions.add(i);
    }

    @Override
      public String toString() {
          return type + " " + index + ", #" + number + ", " + positions;
}

}


