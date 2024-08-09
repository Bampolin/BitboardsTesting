package chess.bot.search;

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
}
