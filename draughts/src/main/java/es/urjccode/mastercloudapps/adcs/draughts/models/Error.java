package es.urjccode.mastercloudapps.adcs.draughts.models;

public enum Error {
    OUT_COORDINATE("No es una coordenada del tablero"), 
    EMPTY_ORIGIN("No hay ninguna ficha en esa coordenada"), 
    OPPOSITE_PIECE("El color de la ficha a mover no corresponde con el turno"), 
    NOT_DIAGONAL("No vas en diagonal"), 
    BAD_DISTANCE("No respetas la distancia"),
    NOT_EMPTY_TARGET("No está vacío el destino"), 
    NOT_ADVANCED("No avanzas"), 
    EATING_EMPTY("No hay ninguna ficha que comer en esa dirección"),
    BAD_INPUT("El formato del movimiento es incorrecto. Debería ser del formato: XY.XY (Origen, Destino)");

    private String message;

    public String getMessageError() {
        return this.message;
    }

    private Error(String message) {
        this.message = message;
    }
}