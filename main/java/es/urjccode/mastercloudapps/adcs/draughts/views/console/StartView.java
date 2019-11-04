package es.urjccode.mastercloudapps.adcs.draughts.views.console;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

/**
 * StartView
 */
public class StartView {

    private Console console;
    private AcceptorController acceptorController;

    public StartView(AcceptorController acceptorController) {
        this.console = new Console();
        this.acceptorController = acceptorController;
    }

    public void writeln() {
        this.console.writeln(Message.GAME_TITLE);
        this.console.writeln(this.acceptorController.getBoard());
    }
}