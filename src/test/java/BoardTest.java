import org.example.Board;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.example.InvalidArguments;
import org.junit.Test;


public class BoardTest {
    @Test
    public void testBoardWithNegativeDimension() {
        assertThrows(InvalidArguments.class,()-> new Board(-4,-4,40));
    }


    @Test
    public void testBoardWithDimension1() {
        assertDoesNotThrow(()-> new Board(1,1,40));
    }


}
