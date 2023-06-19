package model.viewer;

import model.Cell;
import model.Field;

public class ConsoleViewer implements SudokuViewer{

    @Override
    public void printField(Field field) {
        Cell[][] cells = field.getField();;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(cells[i][j].getValue() == 0 ? "* " : cells[i][j].getValue() + " ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0) System.out.println("- - -   - - -   - - -");
        }
    }
}
