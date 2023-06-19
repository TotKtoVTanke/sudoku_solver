package model;

import model.viewer.ConsoleViewer;
import model.viewer.SudokuViewer;

public class Main {

    public static Field field = new Field();
    public static FieldService fieldService = new FieldService(field);
    public static SudokuViewer consoleViewer = new ConsoleViewer();
    public static void main(String[] args) {
        consoleViewer.printField(field);
        fieldService.solving();
        System.out.println("______________________");
        consoleViewer.printField(field);

    }
}
