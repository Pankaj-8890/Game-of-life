import org.example.Board;
import org.example.Board;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    @Test
    public void TestCheckAllDeadWhenThereIsNoAliveCells() {

        Board board = new Board(4,4,0);
        boolean actual = board.checkAllDead();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCheckAllDeadWhenThereIsNoAliveCellsIn1X1Grid() {

        Board board = new Board(1,1,0);
        boolean actual = board.checkAllDead();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCheckAllDeadWhenThereIsAliveCells() {

        Board board = new Board(4,4,10);
        boolean actual = board.checkAllDead();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHavingOneAliveCellsIn1X1Grid() {

        Board board = new Board(1,1,100);
        String actual = board.startGame();
        String expected = "All cells are dead. The game has ended.";
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHavingOAliveCellsIn1X1Grid() {
        Board board = new Board(1,1,50);
        String actual = board.startGame();
        String expected = "All cells are dead. The game has ended.";
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHaving_All_Cells_AliveIn2X2Grid() {

        Board board = new Board(2,2,100);

        String actual = board.startGame();
        String expected = "Can't generate next generation";
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHaving_2_Cells_AliveIn2X2Grid() {

        Board board = new Board(2,2,50);

        String actual = board.startGame();
        String expected = "All cells are dead. The game has ended.";
        assertEquals(expected,actual);
    }



    @Test
    public void TestStartGameHaving_0_Cells_AliveIn0X0Grid() {

        try {
            Board board = new Board(0,0,50);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void TestStartGameHaving_NegativeSeedingValue() {

        try {
            Board board = new Board(4,4,-50);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }
}
