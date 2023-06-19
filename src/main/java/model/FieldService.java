package model;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FieldService {

    private Cell[][] field;
    private Set<Cell> emptyCells = new HashSet<>();
    private CellService cellService = new CellService();

    public FieldService(Field field) {
        this.field = field.getField();
    }

    public void solving() {
        for (int i = 0; i < 9; i++) {
            analyzeCandidatesForAllCells();
            analyzeAllSingleVariants();
        }
        List<Cell> emptyCellsList = new ArrayList<>(emptyCells);
        recurSearch(emptyCellsList, 0);
    }

    private void analyzeCandidatesForAllCells() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!field[i][j].isEmpty()) {
                    analyzeCandidates(field[i][j]);
                } else emptyCells.add(field[i][j]);
            }
        }
    }

    private void analyzeAllSingleVariants() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (field[i][j].isEmpty()) {
                    analyzeSingleCandidate(field[i][j]);
                    analyzeSingleVariant(field[i][j], field[i][j].getQuadroGroup());
                    analyzeSingleVariant(field[i][j], field[i][j].getRowsGroup());
                    analyzeSingleVariant(field[i][j], field[i][j].getColumnsGroup());
                  //  candidateGroupSearch(field[i][j]);
                }
            }
        }
    }

    private void analyzeSingleCandidate(Cell cell) {
        if (cell.isEmpty() && cell.getCandidates().size() == 1) {
            cell.setValue(cell.getCandidates().iterator().next());
            cell.getCandidates().clear();
            cell.setEmpty(false);
            emptyCells.remove(cell);
        }
    }

    private void recurSearch(List<Cell> emptyCells, int n) {
        Cell cell = emptyCells.get(n);
        List<Integer> cands = cell.getCandidates();
        for (Integer cand : cands) {
            if (!alreadyContainValue(cell.getAllCellsGroup(), cand)) {
                cell.setValue(cand);
            if (n < emptyCells.size()-1) {
                int n1 = n+1;
                recurSearch(emptyCells, n1);
            }
            else return;
            }
        }
    }

    private void analyzeSingleVariant(Cell cell, Set<Cell> group) {
        for (int i = 1; i <= 9; i++) {
            int ii = i;
            long count = group
                    .stream()
                    .filter(Cell::isEmpty)
                    .filter(x -> x.getCandidates().contains(ii))
                    .count();
            if (count == 0 && cell.getCandidates().contains(ii) && !alreadyContainValue(group, ii)) {
                cell.setValue(ii);
                cell.getCandidates().clear();
                cell.setEmpty(false);
                emptyCells.remove(cell);
                return;
            }
        }
    }

    private void analyzeCandidates(Cell cell) {
        int value = cell.getValue();
        cell.getAllCellsGroup()
                .stream()
                .filter(Cell::isEmpty)
                .map(x -> cellService.removeCandidate(x, value))
                .filter(x -> !x.isEmpty())
                .forEach(x -> emptyCells.remove(x));
    }

    private boolean alreadyContainValue(Set<Cell> group, int value) {
        return group
                .stream().anyMatch(x -> x.getValue() == value);
    }

    public Set<Cell> getEmptyCells() {
        return emptyCells;
    }

    private boolean equalsCandidatesSet(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
}
