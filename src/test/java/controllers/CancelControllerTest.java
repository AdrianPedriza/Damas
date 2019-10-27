package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import models.Game;
import models.State;
import models.StateValue;

/**
 * CancelControllerTest
 */
public class CancelControllerTest {

    public CancelControllerTest() {

    }

    @Test
    public void givenCancellControllerWhenCancelMovementThenNotError() {
        Game game = new Game();
        CancelController cancelController = new CancelController(game);
        assertNull(cancelController.cancel());
        assertEquals(cancelController.getState(), StateValue.FINAL);
    }
}