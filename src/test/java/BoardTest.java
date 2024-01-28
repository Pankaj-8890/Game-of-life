import org.example.Board;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class BoardTest {
    @Test
    public void testBoardWithNegativeDimension() {
        try {
            Board gameBoard = new Board(4,4,40);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }


    @Test
    public void testBoardWithDimension1() {
        try {
            Board gameBoard = new Board(1,1,50);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void testBoardWithDimension2() {
        try {
            Board gameBoard = new Board(0,0,50);
        } catch (IllegalArgumentException e) {
            assertEquals("values must be greater than 0", e.getMessage());
        }
    }



}
