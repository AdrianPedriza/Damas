package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import models.Game;
import models.Piece;
import models.Coordinate;
import models.Dama;
import models.Color;

public class PlayControllerTest {

    public PlayControllerTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        PlayController playController = new PlayController(game);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenChangePosition() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(2, 1);
        PlayController playController = new PlayController(game);
        assertNotNull(playController.move(origin, target));
        Piece pieceOriginTarget = playController.getPiece(origin);
        assertNotNull(pieceOriginTarget);
        assertEquals(pieceOriginTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereInCorrectThenError() {
        Game game = new Game();
        PlayController playController = new PlayController(game);
        Coordinate origin1 = new Coordinate(2, 1);
        Coordinate target1 = new Coordinate(1, 0);
        assertNull(playController.move(origin1, target1));
        Piece pieceOrigin1 = playController.getPiece(origin1);
        Piece pieceTarget1 = playController.getPiece(target1);
        assertNull(pieceTarget1);
        assertNotNull(pieceOrigin1);
        Coordinate origin2 = new Coordinate(2, 1);
        Coordinate target2 = new Coordinate(2, 2);
        assertNull(playController.move(origin2, target2));
        Piece pieceOrigin2 = playController.getPiece(origin2);
        Piece pieceTarget2 = playController.getPiece(target2);
        assertNull(pieceTarget2);
        assertNotNull(pieceOrigin2);
    }

    @Test
    public void givenPlayControllerWhenDamasCreationThenBoardSquareHasTwoPieces() {
        Game game = new Game();
        Coordinate origin = new Coordinate(6, 0);
        Coordinate target = new Coordinate(7, 1);
        PlayController playController = new PlayController(game);
        playController.move(origin, target);
        Dama dama = new Dama();
        assertEquals(dama, playController.getPiece(target));
        assertNull(origin);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereIsZigZagThenEatPieces() {
        Game game = new Game();
        Coordinate step1 = new Coordinate(3, 1);
        Coordinate step2 = new Coordinate(5, 3);
        Coordinate step3 = new Coordinate(7, 1);
        Coordinate[] path = {step1,step2,step3};
        PlayController playController = new PlayController(game);
        playController.move(path);
        Coordinate coordinatePieceEaten1 = new Coordinate(4, 2);
        Coordinate coordinatePieceEaten2 = new Coordinate(6, 2);
        assertNull(playController.getPiece(coordinatePieceEaten1));
        assertNull(playController.getPiece(coordinatePieceEaten2));
        assertNotNull(playController.getPiece(step3));
    }

}
