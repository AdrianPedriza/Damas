package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class MockedGameTest {

    @InjectMocks
	Game game;

	@Mock
	Board board;

	@Mock
	Turn turn;

    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
        Coordinate origin = new Coordinate(4, 5);
		Coordinate target = new Coordinate(3, 4);
		when(this.board.getColor(origin)).thenReturn(Color.BLACK);
		when(this.turn.isColor(Color.BLACK)).thenReturn(true);
		when(this.board.getPiece(origin)).thenReturn(new Piece(Color.BLACK));
		Error error = game.move(origin, target);
		assertEquals(Error.NOT_ADVANCED, error);
		verify(board, never()).move(origin, target);
    }

    @Test
    public void testGivenGameWhenMoveEmptySquaerThenEmptySquareError() {
		Coordinate origin = new Coordinate(4, 3);
		Coordinate target = new Coordinate(3, 4);
		when(board.isEmpty(origin)).thenReturn(true);
		assertEquals(Error.EMPTY_ORIGIN, this.game.move(origin, target));
		verify(board, never()).move(origin, target);
	}
	
	@Test()
    public void testGivenGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
		Coordinate origin = new Coordinate(4, 7);
		Coordinate target = new Coordinate(3, 8);
		assertEquals(Error.OUT_COORDINATE, this.game.move(origin, target));
        verify(board, never()).move(origin, target);
    }

    @Test
    public void testGivenGameWhenMoveOppositePieceThenError() {
		Coordinate origin = new Coordinate(3, 6);
		Coordinate target = new Coordinate(2, 7);
		when(this.board.getColor(origin)).thenReturn(Color.BLACK);
		when(this.turn.isColor(Color.BLACK)).thenReturn(false);
		assertEquals(Error.OPPOSITE_PIECE, this.game.move(origin, target));
		verify(board, never()).move(origin, target);
    }

    @Test
    public void testGivenGameWhenNotDiagonalMovementThenError() {
        Coordinate origin = new Coordinate(5, 0);
		Coordinate target = new Coordinate(4, 0);
		when(this.board.getColor(origin)).thenReturn(Color.BLACK);
		when(this.turn.isColor(Color.BLACK)).thenReturn(true);
		assertEquals(Error.NOT_DIAGONAL, this.game.move(origin, target));
		verify(board, never()).move(origin, target);
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        Coordinate origin = new Coordinate(3, 0);
		Coordinate target = new Coordinate(5, 2);
		Coordinate between = origin.betweenDiagonal(target);
		when(this.board.getColor(origin)).thenReturn(Color.BLACK);
		when(this.turn.isColor(any(Color.class))).thenReturn(true);
		when(this.board.getPiece(origin)).thenReturn(new Piece(Color.BLACK));
		when(this.board.isEmpty(target)).thenReturn(true);
		when(this.board.getPiece(between)).thenReturn(null);
		assertEquals(Error.EATING_EMPTY, this.game.move(origin, target));
		verify(board, never()).move(origin, target);
    }

    @Test
    public void testGivenGameWhenMoveBadDistanceThenError() {
        Coordinate origin = new Coordinate(5, 0);
		Coordinate target = new Coordinate(2, 3);
		Piece piece = new Piece(Color.WHITE);
		when(this.board.getColor(origin)).thenReturn(Color.WHITE);
		when(this.turn.isColor(Color.WHITE)).thenReturn(true);
		when(this.board.getPiece(origin)).thenReturn(piece);
		Error error = this.game.move(origin, target);
		assertEquals(Error.BAD_DISTANCE, error);
		verify(board, never()).move(origin, target);
    }

}