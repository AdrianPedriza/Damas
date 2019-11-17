package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {

    private int row;
    private int column;
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 7;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Coordinate getInstance(String format){
        assert format != null;
        try {
            int value = Integer.parseInt(format);
            int row = value / 10 - 1;
            int column = value % 10 - 1;
            if (row < Coordinate.LOWER_LIMIT || Coordinate.UPPER_LIMIT < row 
                || column < Coordinate.LOWER_LIMIT || Coordinate.UPPER_LIMIT < column){
                return null;
            }
            return new Coordinate(row, column);
            
        } catch(Exception ex){
            return null;
        } 
    }

    public static Coordinate getInstance(int row, int column){
        if (row < Coordinate.LOWER_LIMIT || Coordinate.UPPER_LIMIT < row 
            || column < Coordinate.LOWER_LIMIT || Coordinate.UPPER_LIMIT < column){
            return null;
        }
        return new Coordinate(row, column);
    }

    boolean isDiagonal(Coordinate coordinate) {
        assert coordinate != null;
        return this.row + this.column == coordinate.row + coordinate.column
                || this.row - this.column == coordinate.row - coordinate.column;
    }

    int diagonalDistance(Coordinate coordinate) {
        assert coordinate != null;
        assert this.isDiagonal(coordinate);
        return Math.abs(this.row - coordinate.row);
    }

    Coordinate betweenDiagonalPawn(Coordinate coordinate) {
        assert coordinate != null;
        assert this.diagonalDistance(coordinate) == 2;
        int rowShift = 1;
        if (coordinate.row - this.row < 0) {
            rowShift = -1;
        }
        int columnShift = 1;
        if (coordinate.column - this.column < 0) {
            columnShift = -1;
        }
        return new Coordinate(this.row + rowShift, this.column + columnShift);
    }

    List<Coordinate> betweenDiagonalDraught(Coordinate coordinate) {
        assert coordinate != null;
        assert this.diagonalDistance(coordinate) > 1;
        
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate auxCoordinate = this;

        do {
            int rowShift = 1;
            if (coordinate.row - auxCoordinate.row < 0) {
                rowShift = -1;
            }
            int columnShift = 1;
            if (coordinate.column - auxCoordinate.column < 0) {
                columnShift = -1;
            }
            auxCoordinate = new Coordinate(auxCoordinate.row + rowShift, auxCoordinate.column + columnShift);
            coordinates.add(auxCoordinate);
        } while(!auxCoordinate.equals(coordinate));
        
        return coordinates;
    }

    Coordinate betweenDiagonal(Coordinate coordinate) {
        assert coordinate != null;
        assert this.diagonalDistance(coordinate) == 2;
        int rowShift = 1;
        if (coordinate.row - this.row < 0) {
            rowShift = -1;
        }
        int columnShift = 1;
        if (coordinate.column - this.column < 0) {
            columnShift = -1;
        }
        return new Coordinate(this.row + rowShift, this.column + columnShift);
    }

    boolean isBlack() {
        return (this.row + this.column) % 2 != 0;
    }

    int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

    public boolean possiblePawnMoves(Piece piece, Board board) {
        List<Coordinate> possibleMoves = this.getPossibleMoves(piece);
        Error error = null;
        for (Coordinate target: possibleMoves) {
            if (target != null ){
                error = piece.isCorrect(this, target, board);
            }
            
        }
        return error == null;
	}

	private List<Coordinate> getPossibleMoves(Piece piece) {
        List<Coordinate> possibleMoves = new ArrayList<>();
        if (piece instanceof Pawn) {
            Coordinate rigthMove = getInstance(this.row - 1, this.column + 1);
            Coordinate leftMove = getInstance(this.row - 1, this.column - 1);
            possibleMoves.add(rigthMove);
            possibleMoves.add(leftMove);
        } else {
            this.getTopLeft(possibleMoves);
            this.getTopRight(possibleMoves);
            this.getBottomLeft(possibleMoves);
            this.getBottomRight(possibleMoves);
        }
        return possibleMoves;
    }

    private void getBottomRight(List<Coordinate> possibleMoves) {
        int rowLimit = this.row;
        int columnLimit = this.column;
        do {
            possibleMoves.add(new Coordinate(rowLimit + 1, columnLimit + 1));
            rowLimit++;
            columnLimit++;
        } while(rowLimit < 8 && columnLimit < 8);
    }

    private void getBottomLeft(List<Coordinate> possibleMoves) {
        int rowLimit = this.row;
        int columnLimit = this.column;
        do {
            possibleMoves.add(new Coordinate(rowLimit + 1, columnLimit - 1));
            rowLimit++;
            columnLimit--;
        } while(rowLimit < 8 && columnLimit > 0);
    }

    private void getTopRight(List<Coordinate> possibleMoves) {
        int rowLimit = this.row;
        int columnLimit = this.column;
        do {
            possibleMoves.add(new Coordinate(rowLimit - 1, columnLimit + 1));
            rowLimit--;
            columnLimit++;
        } while(rowLimit > 0 && columnLimit < 8);
    }

    private void getTopLeft(List<Coordinate> possibleMoves) {
        int rowLimit = this.row;
        int columnLimit = this.column;
        do {
            possibleMoves.add(new Coordinate(rowLimit - 1, columnLimit - 1));
            rowLimit--;
            columnLimit--;
        } while(rowLimit > 0 && columnLimit > 0);
    }

    public List<Coordinate> possibleDraughtMoves() {
        return null;
	}

}