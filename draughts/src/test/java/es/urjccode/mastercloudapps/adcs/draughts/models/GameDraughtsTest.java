package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameDraughtsTest {

    @Mock
    Turn turn;

    @Mock
    Pawn pawn;

    @Mock
    Draught draught;
    
    @Mock
    Board board;

    @InjectMocks
    Game game;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenGameWhenWhitePawnAtLimitThenNewDraugts(){
        Coordinate origin = new Coordinate(1,0);
        Coordinate target = new Coordinate(0,1);

        setWhenConfPawn(origin, target, Color.WHITE);
        
        when(board.getPiece(target)).thenReturn(new Pawn(Color.WHITE));
        game.move(origin, target);
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }

    @Test
    public void testGivenGameWhenWhitePawnAtLimitAndEatingThenNewDraugts(){
        Coordinate origin = new Coordinate(2,1);
        Coordinate target = new Coordinate(0,3);
        setWhenConfPawn(origin, target, Color.WHITE);
        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonalPawn(target));
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }

    @Test
    public void testGivenGameWhenBlackPawnAtLimitThenNewDraugts(){
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(7,2);
        setWhenConfPawn(origin, target, Color.BLACK);
        game.move(origin, target);
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }

    @Test
    public void testGivenGameWhenBlackPawnAtLimitAndEatingThenNewDraugts(){
        Coordinate origin = new Coordinate(5,4);
        Coordinate target = new Coordinate(7,2);
        setWhenConfPawn(origin, target, Color.BLACK);
        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonalPawn(target));
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }

    @Test
    public void testGivenGameWhenWhiteDraughtWantToMoveThenMoveOneSquareReverse() {
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(5,2);

        setWhenConfDraugth(origin, target, Color.WHITE);

        game.move(origin, target);
        verify(board).move(origin, target);
    }

    private void setWhenConfPawn(Coordinate origin, Coordinate target, Color color) {
        when(turn.getColor()).thenReturn(color);
        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(color);
        when(board.getPiece(origin)).thenReturn(pawn);
        when(pawn.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Draught(color));
        when(board.getPiece(target)).thenReturn(new Draught(color));
    }

    private void setWhenConfDraugth(Coordinate origin, Coordinate target, Color color) {
        when(turn.getColor()).thenReturn(color);
        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(color);
        when(board.getPiece(origin)).thenReturn(draught);
        when(draught.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Draught(color));
        when(board.getPiece(target)).thenReturn(new Draught(color));
    }

    @Test
    public void testGivenGameWhenWhiteDraughtWantToMoveThenMoveMoreThanOneSquareReverse() {
        Coordinate origin = new Coordinate(4,1);
        Coordinate target = new Coordinate(6,3);

        setWhenConfDraugth(origin, target, Color.WHITE);

        game.move(origin, target);
        verify(board).move(origin, target);
    }

    @Test
    public void testGivenGameWhenBlackDraughtWantToMoveThenMoveMoreThanOneSquare() {
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(4,1);

        setWhenConfDraugth(origin, target, Color.WHITE);

        game.move(origin, target);
        verify(board).move(origin, target);
    }

    @Test
    public void testGivenGameWhenBlackDraughtWantToMoveThenMoveMoreThanOneSquareReverse() {
        Coordinate origin = new Coordinate(4,1);
        Coordinate target = new Coordinate(6,3);

        setWhenConfDraugth(origin, target, Color.BLACK);

        game.move(origin, target);
        verify(board).move(origin, target);
    }

    @Test
    public void testGivenGameWhenWhiteDraughtWantToEatThenEatOneSquare() {
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(4,1);

        setWhenConfDraugth(origin, target, Color.WHITE);

        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonalDraught(target));
        verify(board).move(origin, target);
    }

    @Test
    public void testGivenGameWhenBlackDraughtWantToEatThenEatOneSquare() {
        Coordinate origin = new Coordinate(4,1);
        Coordinate target = new Coordinate(6,3);

        setWhenConfDraugth(origin, target, Color.BLACK);

        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonalDraught(target));
        verify(board).move(origin, target);
    }

    @Test
    public void testGivenGameWhenWhiteDraughtWantToEatThenEatMoreThanOneSquare() {
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(3,0);

        setWhenConfDraugth(origin, target, Color.WHITE);

        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonalDraught(target));
        verify(board).move(origin, target);
    }

    @Test
    public void testGivenGameWhenBlackDraughtWantToEatThenEatMoreThanOneSquare() {
        Coordinate origin = new Coordinate(4,1);
        Coordinate target = new Coordinate(7,4);

        setWhenConfDraugth(origin, target, Color.BLACK);

        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonalDraught(target));
        verify(board).move(origin, target);
    }
}