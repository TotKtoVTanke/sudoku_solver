package model;

import model.source_receiver.FromFileFieldReceiver;
import model.source_receiver.SudokuFieldReceiver;

import java.util.HashSet;
import java.util.Set;

public class Field {
    Cell[][] field = new Cell[9][9];
    SudokuFieldReceiver sudokuFieldReceiver = new FromFileFieldReceiver();

    public Field() {
        initField();
    }

    private void initField() {
        field = sudokuFieldReceiver.getField();
        initGroups();
    }

    private void initGroups() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j].setQuadroGroup(initQuadroCellsGroups(field[i][j]));
                field[i][j].setColumnsGroup(initCellsGroupsColumns(field[i][j]));
                field[i][j].setRowsGroup(initCellsGroupsRows(field[i][j]));
                field[i][j].setAllCellsGroup();
            }
        }
    }

    private Set<Cell> initCellsGroupsRows(Cell cell) {
        Set<Cell> group = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            int tempX = cell.getX();
            if (cell != field[tempX][i]) group.add(field[tempX][i]);
        }
        group.remove(cell);
        return group;
    }
    private Set<Cell> initCellsGroupsColumns(Cell cell) {
        Set<Cell> group = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            int tempY = cell.getY();
            if (cell != field[i][tempY]) group.add(field[i][tempY]);
        }

        group.remove(cell);
        return group;
    }

    private Set<Cell> initQuadroCellsGroups(Cell cell) {
        Set<Cell> group = new HashSet<>();
        int x = cell.getX();
        int y = cell.getY();
        if (x < 3) {
            if (y < 3) {
                group.add(field[0][0]);
                group.add(field[0][1]);
                group.add(field[0][2]);
                group.add(field[1][0]);
                group.add(field[1][1]);
                group.add(field[1][2]);
                group.add(field[2][0]);
                group.add(field[2][1]);
                group.add(field[2][2]);
            } else if (y < 6) {
                group.add(field[0][3]);
                group.add(field[0][4]);
                group.add(field[0][5]);
                group.add(field[1][3]);
                group.add(field[1][4]);
                group.add(field[1][5]);
                group.add(field[2][3]);
                group.add(field[2][4]);
                group.add(field[2][5]);
            } else if (y < 9) {
                group.add(field[0][6]);
                group.add(field[0][7]);
                group.add(field[0][8]);
                group.add(field[1][6]);
                group.add(field[1][7]);
                group.add(field[1][8]);
                group.add(field[2][6]);
                group.add(field[2][7]);
                group.add(field[2][8]);
            }
        } else if (x < 6) {
            if (y < 3) {
                group.add(field[3][0]);
                group.add(field[3][1]);
                group.add(field[3][2]);
                group.add(field[4][0]);
                group.add(field[4][1]);
                group.add(field[4][2]);
                group.add(field[5][0]);
                group.add(field[5][1]);
                group.add(field[5][2]);
            } else if (y < 6) {
                group.add(field[3][3]);
                group.add(field[3][4]);
                group.add(field[3][5]);
                group.add(field[4][3]);
                group.add(field[4][4]);
                group.add(field[4][5]);
                group.add(field[5][3]);
                group.add(field[5][4]);
                group.add(field[5][5]);
            } else if (y < 9) {
                group.add(field[3][6]);
                group.add(field[3][7]);
                group.add(field[3][8]);
                group.add(field[4][6]);
                group.add(field[4][7]);
                group.add(field[4][8]);
                group.add(field[5][6]);
                group.add(field[5][7]);
                group.add(field[5][8]);
            }
        } else if (x < 9) {
            if (y < 3) {
                group.add(field[6][0]);
                group.add(field[6][1]);
                group.add(field[6][2]);
                group.add(field[7][0]);
                group.add(field[7][1]);
                group.add(field[7][2]);
                group.add(field[8][0]);
                group.add(field[8][1]);
                group.add(field[8][2]);
            } else if (y < 6) {
                group.add(field[6][3]);
                group.add(field[6][4]);
                group.add(field[6][5]);
                group.add(field[7][3]);
                group.add(field[7][4]);
                group.add(field[7][5]);
                group.add(field[8][3]);
                group.add(field[8][4]);
                group.add(field[8][5]);
            } else if (y < 9) {
                group.add(field[6][6]);
                group.add(field[6][7]);
                group.add(field[6][8]);
                group.add(field[7][6]);
                group.add(field[7][7]);
                group.add(field[7][8]);
                group.add(field[8][6]);
                group.add(field[8][7]);
                group.add(field[8][8]);
            }
        }
        group.remove(cell);
        return group;
    }

    public Cell getCell(int x, int y) {
        return this.field[x][y];
    }

    public Cell[][] getField() {
        return field;
    }
}
