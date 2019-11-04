package es.urjccode.mastercloudapps.adcs.draughts.views.console;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

/**
 * BoardView
 */
public class BoardView {

    private Console console;
    private AcceptorController acceptorController;

    public BoardView(AcceptorController acceptorController) {
        this.console = new Console();
        this.acceptorController = acceptorController;
    }

    public void writeln() {
        this.console.writeln(this.acceptorController.getBoard());
    }


}