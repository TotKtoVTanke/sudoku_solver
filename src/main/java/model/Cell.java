package model;

import java.util.*;

public class Cell {
    private final int x;
    private final int y;
    private Integer value;
    private boolean isEmpty = true;
    private List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    private Set<Cell> group = new HashSet<>();

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        if (this.value != 0) {isEmpty = false;
        candidates.clear();}
    }

    public void removeCandidate(Integer candidate){
        this.candidates.remove(candidate);
     //   System.out.println("removed " + candidate + " from cell with x " + x +  " and y " + y);
        if (candidates.size() == 1) {this.value = candidates.get(0);
        candidates.clear();
        isEmpty = false;}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Integer getValue() {
        return value;
    }

    public Cell setValue(Integer value) {
        this.value = value;
        return this;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Cell setEmpty(boolean empty) {
        isEmpty = empty;
        return this;
    }

    public List<Integer> getCandidates() {
        return candidates;
    }

    public Cell setCandidates(List<Integer> candidates) {
        this.candidates = candidates;
        return this;
    }

    public Set<Cell> getGroup() {
        return group;
    }

    public Cell setGroup(Set<Cell> group) {
        this.group = group;
        return this;
    }
}
