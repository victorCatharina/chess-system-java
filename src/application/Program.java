package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exception.ChessException;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {

            try {

                UI.clearScreen();

                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (Objects.nonNull(capturedPiece)) {
                    captured.add(capturedPiece);
                }

                if (Objects.nonNull(chessMatch.getPromoted())) {

                    System.out.println("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine();

                    while (!type.equalsIgnoreCase("B")
                            && !type.equalsIgnoreCase("N")
                            && !type.equalsIgnoreCase("R")
                            && !type.equalsIgnoreCase("Q")) {

                        System.out.println("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine();
                    }

                    chessMatch.replacePromotedPiece(type);
                }

            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
