package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;

public class PlayControllerTest {

    public PlayControllerTest() {

    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        State state = new State();
		Coordinate origin = new Coordinate(5, 2);
		Coordinate target = new Coordinate(4, 3);
        PlayController playController = new PlayController(game, state);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    // public void data(){
    //     Coordinate[][] coordinates = new Coordinate[][] {
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //     };

        // peon mueve una
        // peon come una
        // peon come varias
        // peon se convierte en dama
        // dama mueve una
        // dama mueve varias
        // dama come una
        // dama come varias, atras

    //}


}