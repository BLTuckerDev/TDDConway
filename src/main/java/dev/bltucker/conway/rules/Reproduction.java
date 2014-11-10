package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;

public final class Reproduction implements CellCondition{

    @Override
    public boolean checkCell(Cell cell) {
        return cell.getNeighborCount() == 3;
    }
}
