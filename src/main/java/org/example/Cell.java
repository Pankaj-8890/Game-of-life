package org.example;
import java.util.Objects;

public class Cell {
    private int state;
    public Cell(int state) {
        this.state = state;
    }

    public Boolean isAlive() {
        return state == 1;
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
            return new Cell(0);
        } else {
            return new Cell(1);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        Cell cell = (Cell) o;
        return cell != null && this.state == cell.state;

    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
