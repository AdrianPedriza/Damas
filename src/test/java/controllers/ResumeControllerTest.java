package controllers;

import models.Game;
import models.State;
import models.StateValue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResumeControllerTest {
    public ResumeControllerTest() {

    }

    @Test
    public void givenResumeControllerWhenResumeRequiereCorrectThenNotError() {
        Game game = new Game();
        ResumeController resumeController = new ResumeController(game);
        boolean newGame = true;
        resumeController.resume(newGame);
        assertEquals(resumeController.getState(), StateValue.INITIAL);
        newGame = false;
        resumeController.resume(newGame);
        assertNull(resumeController.getState());
    }
}
