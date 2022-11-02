package chess.chessPieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            //special move en passant white

            if (position.getRow() == 3) {

                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left)
                        && isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {

                    mat[left.getRow() - 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right)
                        && isThereOpponentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {

                    mat[right.getRow() - 1][right.getColumn()] = true;
                }

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

            //special move en passant black

            if (position.getRow() == 4) {

                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left)
                        && isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {

                    mat[left.getRow() + 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right)
                        && isThereOpponentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {

                    mat[right.getRow() + 1][right.getColumn()] = true;
                }

            }

        }

        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
