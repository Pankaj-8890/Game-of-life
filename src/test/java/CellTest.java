import org.example.Board;
import org.example.Cell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void TestCountNeighbourWhenTherisLiveNeighbour() {

        Cell[][] aMatrix = new Cell[3][3];

        aMatrix[0][0] = new Cell(1);
        aMatrix[0][1] = new Cell(0);
        aMatrix[1][0] = new Cell(1);
        aMatrix[1][1] = new Cell(0);
        aMatrix[1][1] = new Cell(1);
        aMatrix[1][1] = new Cell(1);
        aMatrix[1][1] = new Cell(1);
        aMatrix[1][1] = new Cell(0);
        aMatrix[1][1] = new Cell(1);
        Cell cell = new Cell(0);
        assertEquals(2, cell.countLiveNeighbors(aMatrix,1,1));
    }

    @Test
    public void TestCountNeighbourWhenTherisNoLiveNeighbour() {

        Cell[][] aMatrix = new Cell[2][2];

        aMatrix[0][0] = new Cell(0);
        aMatrix[0][1] = new Cell(0);
        aMatrix[1][0] = new Cell(0);
        aMatrix[1][1] = new Cell(0);

        Cell cell = new Cell(0);
        assertEquals(0, cell.countLiveNeighbors(aMatrix,0,1));
    }
}
