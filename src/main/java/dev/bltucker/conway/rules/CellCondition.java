package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;

public interface CellCondition {
    public boolean checkCell(Cell cell);
}
