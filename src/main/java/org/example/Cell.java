package org.example;
import java.util.Objects;

public class Cell {
    private CellType isAlive;
    public Cell(CellType state) {
        this.isAlive = state;
    }

    public Boolean isAlive() {
        return isAlive == CellType.ALIVE;
    }

    public Cell getNextGenerationCell(int liveNeighbors) {
        if (liveNeighbors < 2 || liveNeighbors > 3) {
            return new Cell(CellType.DEAD);
        } else {
            return new Cell(CellType.ALIVE);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        Cell cell = (Cell) o;
        return cell != null && this.isAlive == cell.isAlive;

    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive);
    }
}
