package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * BoardTest
 */
public class BoardTest {

    public BoardTest() {

    }

    // @BeforeClass
    // public static void createSUT() {
    //     Board board = new Board()
    // }

    @Test
    public void givenBoardWhenCleanBoardThenResetPiecesPositionInSquare() {
        Board board = new Board();
        assertNull(board.clean());
        assertEquals(board.getSquares(), new Board());
    }
}