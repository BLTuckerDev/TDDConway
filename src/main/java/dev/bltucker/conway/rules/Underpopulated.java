package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;

public final class Underpopulated implements CellCondition {

    @Override
    public boolean checkCell(Cell cell) {
        return cell.getState().equals(State.LIVE) && cell.getNeighborCount() < 2;
    }
}
