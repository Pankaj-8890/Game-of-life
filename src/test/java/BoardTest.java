import org.example.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;


public class BoardTest {
    @Test
    public void TestBoardWithNegativeDimension() {
        assertThrows(InvalidArguments.class,()-> new Board(-4,-4,40));
    }


    @Test
    public void TestBoardWithDimension1() {
        assertDoesNotThrow(()-> new Board(1,1,40));
    }

    @Test
    public void TestToCheckNextGenerationWhenThereIsOnly1AliveCell() throws InvalidArguments, GenerationNotPossible {

        Board board = new Board(10,10,1);
        board.nextGenerationBoard();
        assertTrue(board.checkAllDead());
    }

    @Test
    public void TestToCheckNextGenerationWhenThereIsOnlyAllAliveCells() throws InvalidArguments, GenerationNotPossible {

        Board board = new Board(4,4,100);
        board.nextGenerationBoard();
        assertFalse(board.checkAllDead());
    }

    @Test
    public void TestExceptionWhenThereIsNoNextGenerationPossible() throws InvalidArguments {

        Board board = new Board(2,2,100);
        assertThrows(GenerationNotPossible.class, board::nextGenerationBoard);
    }

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
