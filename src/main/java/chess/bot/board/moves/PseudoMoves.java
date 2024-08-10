package chess.bot.board.moves;

import chess.bot.board.Piece;
import chess.bot.board.PiecesListBoard;

import java.util.ArrayList;
import java.util.List;

public class PseudoMoves {
    public static List<Integer> rookMoves(int[] board, int position) {
        List<Integer> cordsSelf;
        List<Integer> cordsEnemy;
        PiecesListBoard listBoard = new PiecesListBoard(board);

        if (Piece.isWhite(board[position])) {
            cordsSelf = listBoard.getWhitePiecesCords();
            cordsEnemy = listBoard.getBlackPiecesCords();
        } else {
            cordsSelf = listBoard.getBlackPiecesCords();
            cordsEnemy = listBoard.getWhitePiecesCords();
        }

        return rookMoves(board, position, cordsSelf, cordsEnemy);
    }

    public static List<Integer> rookMoves(int[] board, int position, List<Integer> cordsSelf, List<Integer> cordsEnemy) {
        List<Integer> moves = new ArrayList<>();

        // up
        if (position <= 63 - 8)
        {
            for (int i = position + 8; i <= 63; i += 8) {

                if (cordsSelf.contains(i)) {
                    break;
                }

                if (cordsEnemy.contains(i)) {
                    moves.add(i);
                    break;
                }

                moves.add(i);
            }
        }

        // down
        if (position >= 8)
        {
            for (int i = position - 8; i >= 0; i -= 8) {

                if (cordsSelf.contains(i)) {
                    break;
                }

                if (cordsEnemy.contains(i)) {
                    moves.add(i);
                    break;
                }

                moves.add(i);
            }
        }

        // right
        int movesToRight = position % 8;

        int i = position;
        while (movesToRight > 0) {
            i -= 1;
            movesToRight -= 1;

            if (cordsSelf.contains(i)) {
                break;
            }

            if (cordsEnemy.contains(i)) {
                moves.add(i);
                break;
            }

            moves.add(i);
        }


        // left
        int movesToLeft = 7 - (position % 8);
        i = position;
        while (movesToLeft > 0) {
            i += 1;
            movesToLeft -= 1;

            if (cordsSelf.contains(i)) {
                break;
            }

            if (cordsEnemy.contains(i)) {
                moves.add(i);
                break;
            }

            moves.add(i);
        }

        return moves;
    }


    public static List<Integer> bishopMoves(int[] board, int position) {
        List<List<Integer>> pieces = findPiecesLists(board, position);
        return bishopMoves(board, position, pieces.get(0), pieces.get(1));
    }

    public static List<Integer> bishopMoves(int[] board, int position, List<Integer> cordsSelf, List<Integer> cordsEnemy) {
        List<Integer> moves = new ArrayList<>();

        final int MOVESUP = 7 - (position / 8);
        final int MOVESDOWN = position / 8;
        final int MOEVSLEFT = 7 - (position % 8);
        final int MOVESRIGHT = position % 8;

        // vor jeder schleife die zwei werte kopieren und abfahrt


        // +7 | left up



        // +9 | right up



        // -7 | left down



        // -9 | right down




        return moves;
    }

    public static List<List<Integer>> findPiecesLists(int[] board, int position) {
        List<List<Integer>> result = new ArrayList<>();
        PiecesListBoard listBoard = new PiecesListBoard(board);

        if (Piece.isWhite(board[position])) {
            result.add(listBoard.getWhitePiecesCords());
            result.add(listBoard.getBlackPiecesCords());
        } else {
            result.add(listBoard.getBlackPiecesCords());
            result.add(listBoard.getWhitePiecesCords());
        }

        return result;
    }
}
