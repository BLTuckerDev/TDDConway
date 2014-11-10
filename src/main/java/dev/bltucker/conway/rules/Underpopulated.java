package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;

public final class Underpopulated implements CellCondition {

    @Override
    public boolean checkCell(Cell cell) {
        return cell.getNeighborCount() < 2;
    }
}
