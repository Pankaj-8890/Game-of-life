import org.example.*;
import org.example.Board;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {


    @Test
    public void TestEqualByComparingTwoNonEqualGrids() throws InvalidArguments {

        Board board = new Board(2, 2,0);
        Cell[][] aMatrix = new Cell[2][2];

        aMatrix[0][0] = new Cell(0);
        aMatrix[0][1] = new Cell(0);
        aMatrix[1][0] = new Cell(1);
        aMatrix[1][1] = new Cell(1);
        Board anotherBoard = new Board(2, 2, aMatrix);
        assertEquals(false, board.equals(anotherBoard));
    }

    @Test
    public void TestEqualByComparingTwoEqualGridsWhenAllAre1() throws InvalidArguments {

        Board board = new Board(2, 2,100);
        Cell[][] aMatrix = new Cell[2][2];

        aMatrix[0][0] = new Cell(1);
        aMatrix[0][1] = new Cell(1);
        aMatrix[1][0] = new Cell(1);
        aMatrix[1][1] = new Cell(1);
        Board anotherBoard = new Board(2, 2, aMatrix);
        assertEquals(true, board.equals(anotherBoard));
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
    public void TestStartGameHavingOneAliveCellsIn1X1Grid() throws Exception {

        Board board = new Board(1,1,100);
        assertThrows(Exception.class,()-> board.startGame());
    }

    @Test
    public void TestStartGameHavingOAliveCellsIn1X1Grid() throws Exception {
        Board board = new Board(1,1,50);
        assertThrows(Exception.class,()-> board.startGame());

    }

    @Test
    public void TestStartGameHaving_All_Cells_AliveIn2X2Grid() throws Exception {

        Board board = new Board(2,2,100);
        assertThrows(GenerationNotPossible.class,()-> board.startGame());

    }

    @Test
    public void TestEqualByComparingTwoEqualGrids() throws InvalidArguments {

        Board board = new Board(2, 2,100);
        Board anotherBoard = new Board(2, 2,100);
        assertEquals(true, board.equals(anotherBoard));
    }

}
