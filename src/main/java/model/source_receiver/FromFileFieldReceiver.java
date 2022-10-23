package model.source_receiver;

import model.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FromFileFieldReceiver implements SudokuFieldReceiver{


    @Override
    public Cell[][] getField() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("F:\\Viks\\sudoku_solver\\example.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Cell[][] field = new Cell[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = new Cell(i, j, sc.nextInt());
            }
        }
        return field;
    }
}
