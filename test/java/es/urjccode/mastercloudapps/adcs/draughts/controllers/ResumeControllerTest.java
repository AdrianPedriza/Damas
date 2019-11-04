package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class ResumeControllerTest {

	public ResumeControllerTest() {
	}

	private ResumeController resumeController;

	@Before
	public void before() {
		resumeController = new ResumeController(new Game(), new State());
	}

	@Test
	public void givenResumeControllerWhenResumeGameMoveToInitialStateRequiereCorrectThenNotError() {
		resumeController.resume(false);
		resumeController.resume(false);
		assertEquals(StateValue.FINAL, resumeController.getStateValue());
		resumeController.resume(true);
		assertEquals(StateValue.INITIAL, resumeController.getStateValue());
	}

}