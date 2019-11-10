package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    public CommandView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String[] command = this.console.readString("Mueven las " + color + ": ").split("-");
            int origin = Integer.parseInt(command[0]);
            int target = Integer.parseInt(command[1]);
            error = playController.move(new Coordinate(origin), new Coordinate(target));
            if (error != null){
                console.writeln(new ErrorView(error).getMessage());
            }
            gameView.write(playController);
        } while (error != null); 
        if (playController.isBlocked()){
            this.console.write(MessageView.DEFEAT.getMessage());
        }
    }

}