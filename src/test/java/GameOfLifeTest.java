import org.example.Board;
import org.example.GameOfLife;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    @Test
    public void TestCheckAllDeadWhenThereIsNoAliveCells() {

        GameOfLife gameOfLife = new GameOfLife(4,4,0);
        boolean actual = gameOfLife.checkAllDead();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCheckAllDeadWhenThereIsNoAliveCellsIn1X1Grid() {

        GameOfLife gameOfLife = new GameOfLife(1,1,0);
        boolean actual = gameOfLife.checkAllDead();
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCheckAllDeadWhenThereIsAliveCells() {

        GameOfLife gameOfLife = new GameOfLife(4,4,10);
        boolean actual = gameOfLife.checkAllDead();
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHavingOneAliveCellsIn1X1Grid() {

        GameOfLife gameOfLife = new GameOfLife(1,1,100);
        String actual = gameOfLife.startGame();
        String expected = "All cells are dead. The game has ended.";
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHavingOAliveCellsIn1X1Grid() {
        GameOfLife gameOfLife = new GameOfLife(1,1,50);
        String actual = gameOfLife.startGame();
        String expected = "All cells are dead. The game has ended.";
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHaving_All_Cells_AliveIn2X2Grid() {

        GameOfLife gameOfLife = new GameOfLife(2,2,100);

        String actual = gameOfLife.startGame();
        String expected = "Can't generate next generation";
        assertEquals(expected,actual);
    }

    @Test
    public void TestStartGameHaving_2_Cells_AliveIn2X2Grid() {

        GameOfLife gameOfLife = new GameOfLife(2,2,50);

        String actual = gameOfLife.startGame();
        String expected = "All cells are dead. The game has ended.";
        assertEquals(expected,actual);
    }



    @Test
    public void TestStartGameHaving_0_Cells_AliveIn0X0Grid() {

        try {
            GameOfLife gameOfLife = new GameOfLife(0,0,50);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void TestStartGameHaving_NegativeSeedingValue() {

        try {
            GameOfLife gameOfLife = new GameOfLife(4,4,-50);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }










}
