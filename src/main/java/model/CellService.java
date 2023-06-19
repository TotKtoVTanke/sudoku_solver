package model;

import java.util.List;

public class CellService {

    public Cell removeCandidate(Cell cell, Integer candidate){
        List<Integer> candidates = cell.getCandidates();
        candidates.remove(candidate);
        if (candidates.size() == 1) {cell.setValue(candidates.iterator().next());
            candidates.clear();
            cell.setEmpty(false);
        }
        return cell;
    }
}
