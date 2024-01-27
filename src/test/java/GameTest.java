import org.example.GameOfLife;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameTest {

    @Test
    public void testUpdateGridWhen_LiveCell_Having_LessThan2_LiveNeighbour() {

        GameOfLife game = new GameOfLife(1,1,1);
        int[][] board = {{0,1,0},
                         {0,1,0},
                         {0,0,0}};
        int[][] actual = game.updateGrid(board);
        int[][] expected = {{0,1,0},
                            {0,0,0},
                            {0,0,0}};

        assertArrayEquals(expected,actual);
    }


    @Test
    public void testUpdateGridWhen_LiveCell_Having_2_LiveNeighbour() {

        GameOfLife game = new GameOfLife(2,1,1);
        int[][] board = {{0,1,0},
                         {1,1,0},
                         {0,0,0}};
        int[][] actual = game.updateGrid(board);
        int[][] expected = {{0,1,0},
                            {1,1,0},
                            {0,0,0}};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void testUpdateGridWhen_LiveCell_Having_4_LiveNeighbour() {

        GameOfLife game = new GameOfLife(4,1,1);
        int[][] board = {{0,1,0},
                         {1,1,1},
                         {0,1,0}};
        int[][] actual = game.updateGrid(board);
        int[][] expected = {{0,1,0},
                            {1,0,1},
                            {0,1,0}};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void testUpdateGridWhen_LiveCell_Having_3_LiveNeighbour() {

        GameOfLife game = new GameOfLife(3,1,1);
        int[][] board = {{0,1,0},
                         {1,1,1},
                         {0,0,0}};
        int[][] actual = game.updateGrid(board);
        int[][] expected = {{0,1,0},
                            {1,1,1},
                            {0,0,0}};

        assertArrayEquals(expected,actual);
    }
}
