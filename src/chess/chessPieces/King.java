package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

import java.util.Objects;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {

        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return Objects.isNull(p) || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {

        ChessPiece piece = (ChessPiece) getBoard().piece(position);

        return Objects.nonNull(piece)
                && piece instanceof Rook
                && piece.getColor() == getColor()
                && piece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above

        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //below

        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //left

        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //right

        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //nw

        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne

        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //sw

        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        //se

        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }

        // #special move castling

        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #special move castling king side rook

            Position  positionFirstRook = new Position(position.getRow(), position.getColumn() + 3);

            if (testRookCastling(positionFirstRook)) {

                Position position1 = new Position(position.getRow(), position.getColumn() + 1);
                Position position2 = new Position(position.getRow(), position.getColumn() + 2);

                if (Objects.isNull(getBoard().piece(position1))
                        && Objects.isNull(getBoard().piece(position2))) {

                    mat[position.getRow()][position.getColumn() + 2] = true;
                }

            }

            // #special move castling queen side rook

            Position  positionSecondRook = new Position(position.getRow(), position.getColumn() - 4);

            if (testRookCastling(positionSecondRook)) {

                Position position1 = new Position(position.getRow(), position.getColumn() - 1);
                Position position2 = new Position(position.getRow(), position.getColumn() - 2);
                Position position3 = new Position(position.getRow(), position.getColumn() - 3);


                if (Objects.isNull(getBoard().piece(position1))
                        && Objects.isNull(getBoard().piece(position2))
                        && Objects.isNull(getBoard().piece(position3))) {

                    mat[position.getRow()][position.getColumn() - 2] = true;
                }

            }

        }

        return mat;
    }

    @Override
    public String toString() {

        return "K";
    }
}
