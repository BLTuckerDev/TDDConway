package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;

public final class Reproduction implements CellCondition{

    @Override
    public boolean checkCell(Cell cell) {
        return cell.getState().equals(State.DEAD) && cell.getLiveNeighborCount() == 3;
    }
}
