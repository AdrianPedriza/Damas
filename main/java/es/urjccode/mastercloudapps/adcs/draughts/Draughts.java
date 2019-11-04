package es.urjccode.mastercloudapps.adcs.draughts;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.Logic;
import es.urjccode.mastercloudapps.adcs.draughts.views.View;
import es.urjccode.mastercloudapps.adcs.draughts.views.console.ConsoleView;

/**
 * Draughts
 */
public class Draughts {

    private Logic logic;
	
	private View view;
	
	public Draughts() {
		this.logic = new Logic();
		this.view = new ConsoleView();
    }
    
	public void play() {
		AcceptorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.view.interact(controller);
			}
		} while (controller != null); 
    }
    
    public static void main(String[] args) {
        new Draughts().play();
    }
}