import org.example.*;
import org.example.Board;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {


    @Test
    public void TestEqualByComparingTwoNonEqualGrids() throws InvalidArguments {

        Board board = new Board(2, 2,0);
        Cell[][] aMatrix = new Cell[2][2];

        aMatrix[0][0] = new Cell(CellType.DEAD);
        aMatrix[0][1] = new Cell(CellType.DEAD);
        aMatrix[1][0] =new Cell(CellType.ALIVE);
        aMatrix[1][1] =new Cell(CellType.ALIVE);
        Board anotherBoard = new Board(2, 2, aMatrix);
        assertFalse(board.equals(anotherBoard));
    }

    @Test
    public void TestEqualByComparingTwoEqualGridsWhenAllAre1() throws InvalidArguments {

        Board board = new Board(2, 2,100);
        Cell[][] aMatrix = new Cell[2][2];

        aMatrix[0][0] =new Cell(CellType.ALIVE);
        aMatrix[0][1] =new Cell(CellType.ALIVE);
        aMatrix[1][0] =new Cell(CellType.ALIVE);
        aMatrix[1][1] =new Cell(CellType.ALIVE);
        Board anotherBoard = new Board(2, 2, aMatrix);
        assertTrue(board.equals(anotherBoard));
    }

    @Test
    public void TestCheckAllDeadWhenThereIsNoAliveCells()throws Exception {

        Board board = new Board(4,4,0);
        boolean actual = board.checkAllDead();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCheckAllDeadWhenThereIsNoAliveCellsIn1X1Grid() throws Exception {

        Board board = new Board(1,1,0);
        boolean actual = board.checkAllDead();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCheckAllDeadWhenThereIsAliveCells() throws Exception {

        Board board = new Board(4,4,10);
        boolean actual = board.checkAllDead();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void TestEqualByComparingTwoEqualGrids() throws InvalidArguments {

        Board board = new Board(2, 2,100);
        Board anotherBoard = new Board(2, 2,100);
        assertTrue(board.equals(anotherBoard));
    }

}
