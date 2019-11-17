package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Board implements PieceProvider {

    private static final int DIMENSION = 8;
    private Square[][] squares;

    Board() {
        this.squares = new Square[this.getDimension()][this.getDimension()];
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    private Square getSquare(Coordinate coordinate){
        assert coordinate!=null;
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    void put(Coordinate coordinate, Piece piece){
        assert piece != null;
        this.getSquare(coordinate).put(piece);
    }

    Piece remove(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    void move(Coordinate origin, Coordinate target) {
        this.put(target, this.remove(origin));
    }

    @Override
    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    @Override
    public boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }
    
    Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<Piece>();
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                pieces.add(this.squares[i][j].getPiece());
            }
        }
		return pieces;
    }
    
    void remove(List<Coordinate> coordinates) {
        assert coordinates.size() != 0;
        for (Coordinate c: coordinates) {
            this.getSquare(c).remove();
        } 
    }
    
    int getDimension() {
		return Board.DIMENSION;
	}

    @Override
    public String toString() {
        String string = "";
        string += this.toStringHorizontalNumbers();
        for (int i = 0; i < this.getDimension(); i++) {
            string += this.toStringHorizontalPiecesWithNumbers(i);
        }
        string += this.toStringHorizontalNumbers();
        return string;
    }

    private String toStringHorizontalNumbers(){
        String string = " ";
        for (int j = 0; j < Board.DIMENSION; j++) {
            string += j;
        }
        return string + "\n";
    }

    private String toStringHorizontalPiecesWithNumbers(int row){
        String string = "" + row;
        for (int j = 0; j < this.getDimension(); j++) {
            Piece piece = this.getPiece(new Coordinate(row, j));
            if (piece == null) {
                string += " ";
            } else {
                final String[] letters = {"b","n"};
                string += letters[piece.getColor().ordinal()];
            }
        }
        return string + row + "\n";
    }

    boolean canMove(Color color) {
        Map<Piece, Coordinate> pieces = new HashMap<>();
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                Piece piece = this.squares[i][j].getPiece();
                if (piece != null && piece.getColor().equals(color)) {
                    pieces.put(this.squares[i][j].getPiece(), new Coordinate(i, j));
                }

            }
        }
        for (Entry<Piece, Coordinate> piece: pieces.entrySet()) {
            if (piece.getKey() instanceof Pawn && piece.getValue().possiblePawnMoves(piece.getKey(), this)) {
                return true;
            }else if (piece.getKey() instanceof Draught && piece.getValue().possibleDraughtMoves().size() > 0) {
                return true;
            }
        }
        return false;
    }

    

}