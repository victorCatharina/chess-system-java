package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position1 = new Position(0, 0);

        if (getColor() == Color.WHITE) {

            position1.setValues(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(position1) && !getBoard().thereIsAPiece(position1)) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

            position1.setValues(position.getRow() - 2, position.getColumn());
            Position position2 = new Position(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(position1)
                    && !getBoard().thereIsAPiece(position1)
                    && getBoard().positionExists(position2)
                    && !getBoard().thereIsAPiece(position2)
                    && getMoveCount() == 0) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

            position1.setValues(position.getRow() - 1, position.getColumn() - 1);

            if (getBoard().positionExists(position1) && isThereOpponentPiece(position1)) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

            position1.setValues(position.getRow() - 1, position.getColumn() + 1);

            if (getBoard().positionExists(position1) && isThereOpponentPiece(position1)) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

        }
        else {

            position1.setValues(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(position1) && !getBoard().thereIsAPiece(position1)) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

            position1.setValues(position.getRow() + 2, position.getColumn());
            Position position2 = new Position(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(position1)
                    && !getBoard().thereIsAPiece(position1)
                    && getBoard().positionExists(position2)
                    && !getBoard().thereIsAPiece(position2)
                    && getMoveCount() == 0)  {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

            position1.setValues(position.getRow() + 1, position.getColumn() - 1);

            if (getBoard().positionExists(position1) && isThereOpponentPiece(position1)) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }

            position1.setValues(position.getRow() + 1, position.getColumn() + 1);

            if (getBoard().positionExists(position1) && isThereOpponentPiece(position1)) {

                mat[position1.getRow()][position1.getColumn()] = true;
            }
        }

        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
