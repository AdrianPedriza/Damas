package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public class StartView {

    private Console console;

    public StartView(){
        this.console = new Console();
    }

    public void interact(StartController startController) {
        this.console.writeln(MessageView.TITTLE.getMessage());
        new GameView().write(startController);
        startController.start();
    }
}