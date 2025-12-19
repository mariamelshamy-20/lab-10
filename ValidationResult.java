
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    public String state; // added by mariam
    public boolean valid;
    public List<DuplicateError> errors;
    public int[][] board;   
    
    
    public ValidationResult(int[][] board) {
        this.valid = true;
        this.errors= Collections.synchronizedList(new ArrayList<>());// to make it threadsafe
        this.board = board;
    }

    public void  addError(DuplicateError e) {
        this.errors.add(e);
        this.valid = false;
    }
     public boolean isValid() {
        return "VALID".equals(state); //added by mariam
    }

    public boolean isIncomplete() { // added by mariam
        return "INCOMPLETE".equals(state);
    }

    public boolean isInvalid() { //added by mariam
        return "INVALID".equals(state);
    }
}
