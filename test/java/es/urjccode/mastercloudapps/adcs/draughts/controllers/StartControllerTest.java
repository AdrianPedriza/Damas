package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class StartControllerTest {

	public StartControllerTest() {
	}

	private StartController startController;

	@Before
	public void before() {
		startController = new StartController(new Game(), new State());
	}

	@Test
	public void givenStartControllerWhenStartGameThenNextStateValue() {
		assertEquals(StateValue.INITIAL, startController.getState());
		startController.start();
		assertEquals(StateValue.IN_GAME, startController.getState());
	}
}