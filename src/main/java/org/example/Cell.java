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

    public int countLiveNeighbors(Cell[][] board, int x, int y) {
        int count = 0;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] dir : directions) {
            int neighbourX = x + dir[0];
            int neighbourY = y + dir[1];

            if (neighbourX >= 0 && neighbourX < board.length && neighbourY >= 0 && neighbourY < board[0].length
                    && board[neighbourX][neighbourY] != null && board[neighbourX][neighbourY].isAlive()) {
                count++;
            }
        }
        return count;
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
