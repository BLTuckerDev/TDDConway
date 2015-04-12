package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;

public final class Homeostasis implements CellCondition {

    @Override
    public boolean checkCell(Cell cell) {
        return cell.getState().equals(State.LIVE) &&
                ( cell.getLiveNeighborCount() == 2 || cell.getLiveNeighborCount() == 3 );
    }
}
