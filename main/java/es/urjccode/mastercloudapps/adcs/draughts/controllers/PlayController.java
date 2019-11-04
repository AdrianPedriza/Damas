package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayController extends AcceptorController{

    public PlayController(Game game, State state) {
		super(game, state);
	}

	public Error move(Coordinate origin, Coordinate target){
        return game.move(origin, target);
    }

	public Piece getPiece(Coordinate origin) {
		return this.game.getPiece(origin);
	}

	public Color getColor() {
		return Color.WHITE;
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public void next() {
		this.state.next();
	}

	public boolean isWinner() {
		return false;
	}

	public boolean isFinished() {
		return false;
	}
}