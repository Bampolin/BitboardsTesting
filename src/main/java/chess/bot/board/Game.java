package chess.bot.board;

import chess.bot.board.moves.PseudoMoves;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Game {
    private Stack<Board> states;

    public Game() {
        states = new Stack<>();
    }

    // false = white, true = black
    public boolean turn() {
        return states.size() % 2 != 0;
    }

    public void undoMove() {
        states.pop();
    }

    public List<Move> findMoves() {
        List<Move> result = new ArrayList<>();
        List<Integer> friendly;
        List<Integer> enemy;

        PiecesListBoard piecesListBoard = new PiecesListBoard(states.getLast());

        if (turn()) {
            friendly = piecesListBoard.getBlackPiecesCords();
            enemy = piecesListBoard.getWhitePiecesCords();
        } else {
            friendly = piecesListBoard.getWhitePiecesCords();
            enemy = piecesListBoard.getBlackPiecesCords();
        }





        for (int from : friendly) {

            if (Piece.isKing(from)) {



            } else {
                List<Integer> pseudo;

                if (Piece.isRook(from)) {
                    pseudo = PseudoMoves.rookMoves(states.getLast().getBoard(), from, friendly, enemy);
                } else if (Piece.isBishop(from)) {
                    pseudo = PseudoMoves.bishopMoves(states.getLast().getBoard(), from, friendly, enemy);
                } else if (Piece.isQueen(from)) {
                    pseudo = PseudoMoves.queenMoves(states.getLast().getBoard(), from, friendly, enemy);
                } else if (Piece.isKnight(from)) {
                    pseudo = PseudoMoves.knightMoves(states.getLast().getBoard(), from, friendly, enemy);
                } else {
                    if (turn()) {
                        pseudo = PseudoMoves.blackPawnMoves(states.getLast().getBoard(), from, friendly, enemy, states.getLast().getEnPassantOnSquare());
                    } else {
                        pseudo = PseudoMoves.whitePawnMoves(states.getLast().getBoard(), from, friendly, enemy, states.getLast().getEnPassantOnSquare());
                    }
                }

                // Schach

                List<Move> valid = new ArrayList<>();

                for (int to : pseudo) {
                    Move move = new Move(from, to);

                    makeMove(move);

                    if (!kingInCheck(!turn())) {
                        valid.add(move);
                    }

                    undoMove();
                }

            }



        }


        return result;
    }

    // keine überprüfung mehr, ob der zug erlaubt ist, aus performance-gründen
    public void makeMove(Move move) {



    }

    public boolean whiteKingInCheck() {
        return false;
    }

    public boolean blackKingInCheck() {
        return false;
    }

    public boolean kingInCheck(boolean color) {
        // false = white
        // true = black

        return color ?  blackKingInCheck() : whiteKingInCheck();
    }
}