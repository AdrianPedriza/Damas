package controllers;

import static org.junit.Assert.assertEquals;

import models.StateValue;

public class StartControllerTest {

    public StartControllerTest() {
        
    }

    public void givenStartControllerWhenStartGameThenNextStateIsInGame() {
        StartController startController = new StartController();
        startController.start();
        assertEquals(startController.getState(), StateValue.IN_GAME);
    }
}
