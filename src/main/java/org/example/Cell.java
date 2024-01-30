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

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        Cell cell = (Cell) o;
        return this.state == cell.state && this.hashCode() == cell.hashCode();

    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
