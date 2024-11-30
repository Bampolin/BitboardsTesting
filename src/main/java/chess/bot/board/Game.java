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

        PiecesListBoard piecesListBoard = new PiecesListBoard(states.peek());

        friendly = turn()
                ? piecesListBoard.getBlackPiecesCords()
                : piecesListBoard.getWhitePiecesCords();

        enemy = turn()
                ? piecesListBoard.getWhitePiecesCords()
                : piecesListBoard.getBlackPiecesCords();



        for (int from : friendly) {

            int pieceFrom = getCurrentBoard().getBoard()[from];
            List<Integer> pseudo;

            if (Piece.isKing(from)) {

                pseudo = PseudoMoves.kingMoves(getCurrentBoard().getBoard(), from, friendly, enemy);




            } else {

                if (Piece.isRook(pieceFrom)) {
                    pseudo = PseudoMoves.rookMoves(getCurrentBoard().getBoard(), from, friendly, enemy);
                } else if (Piece.isBishop(pieceFrom)) {
                    pseudo = PseudoMoves.bishopMoves(getCurrentBoard().getBoard(), from, friendly, enemy);
                } else if (Piece.isQueen(pieceFrom)) {
                    pseudo = PseudoMoves.queenMoves(getCurrentBoard().getBoard(), from, friendly, enemy);
                } else if (Piece.isKnight(pieceFrom)) {
                    pseudo = PseudoMoves.knightMoves(getCurrentBoard().getBoard(), from, friendly, enemy);
                } else {
                    if (turn()) {
                        pseudo = PseudoMoves.blackPawnMoves(getCurrentBoard().getBoard(), from, friendly, enemy, getCurrentBoard().getEnPassantOnSquare());
                    } else {
                        pseudo = PseudoMoves.whitePawnMoves(getCurrentBoard().getBoard(), from, friendly, enemy, getCurrentBoard().getEnPassantOnSquare());
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

    public Board getCurrentBoard() {
        return states.peek();
    }
}