package es.urjccode.mastercloudapps.adcs.draughts.views.console;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ResumeController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.YesNoDialog;
import es.urjccode.mastercloudapps.adcs.draughts.views.View;

public class ConsoleView extends View {

    @Override
    public void visit(StartController startController) {
        startController.start();
        new StartView(startController).writeln();
    }

    @Override
    public void visit(PlayController playController) {
        new CommandView(playController).interact();
        new BoardView(playController).writeln();
        if (playController.isWinner() || playController.isFinished()) {
            playController.next();
        }
    }

    @Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

    @Override
    public void visit(ResumeController resumeController) {
        new ResumeView(resumeController).interact();
    }

}