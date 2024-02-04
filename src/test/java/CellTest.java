import org.example.Board;
import org.example.Cell;
import org.example.CellType;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void TestAbleToReturnAliveCellWhenDeadCellHas3AliveNeighbour() {

        Cell cell = new Cell(CellType.DEAD);
        Cell newCell = cell.getNextGenerationCell(3);
        assertTrue(newCell.isAlive());
    }

    @Test
    public void TestAbleToReturnDeadCellWhenAliveCellHaslessThan2AliveNeighbour() {

        Cell cell = new Cell(CellType.ALIVE);
        Cell newCell = cell.getNextGenerationCell(1);
        assertFalse(newCell.isAlive());
    }

    @Test
    public void TestAbleToReturnDeadCellWhenAliveCellHasGreaterThan3AliveNeighbour() {

        Cell cell = new Cell(CellType.ALIVE);
        Cell newCell = cell.getNextGenerationCell(4);
        assertFalse(newCell.isAlive());
    }
}
