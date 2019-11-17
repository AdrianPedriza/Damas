package es.urjccode.mastercloudapps.adcs.draughts.views;

public enum MessageView {
    TITTLE("Draughts"),
    REPEAT_GAME_QUESTION("¿Queréis jugar otra"),
    DEFEAT("Derrota!!! No puedes mover tus fichas!!!");

    private String message;

    private MessageView(String message) {
		this.message = message;
    }

    public String getMessage() {
		return this.message;
	}

} 