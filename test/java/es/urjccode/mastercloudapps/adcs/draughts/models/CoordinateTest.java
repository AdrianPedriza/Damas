package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

    @Test
    public void testGivenTwoCoordinatesWhenBettweenDiagonalThenOk() {
        assertEquals(new Coordinate(1, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 0)));
        assertEquals(new Coordinate(3, 1), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 0)));
        assertEquals(new Coordinate(3, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(4, 4)));
        assertEquals(new Coordinate(1, 3), new Coordinate(2, 2).betweenDiagonal(new Coordinate(0, 4)));
    }

    @Test
    public void testGivenACoordinateWhenCalculateDiagonalDistanceThenCorrectCaculation(){
        assertEquals(diagonalDistance(3),new Coordinate(3, 4).diagonalDistance(new Coordinate(0, 7)));
    }

    @Test
    public void testGivenACoordinateWhenCheckACoordinateThenCorrectChecking(){
        assertTrue(new Coordinate(2, 7).isValid());
        assertFalse(new Coordinate(2, 9).isValid());
    }

    private int diagonalDistance(int i) {
        return i;
    }

}