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
        moves.addAll(movesInLine(movesUpForPos(position), 8, position, cordsSelf, cordsEnemy));

        // down
        moves.addAll(movesInLine(movesDownForPos(position), -8, position, cordsSelf, cordsEnemy));

        // right
        moves.addAll(movesInLine(movesRightForPos(position), -1, position, cordsSelf, cordsEnemy));

        // left
        moves.addAll(movesInLine(movesLeftForPos(position), 1, position, cordsSelf, cordsEnemy));

        /*
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

         */

        return moves;
    }


    public static List<Integer> bishopMoves(int[] board, int position) {
        List<List<Integer>> pieces = findPiecesLists(board, position);
        return bishopMoves(board, position, pieces.get(0), pieces.get(1));
    }

    public static List<Integer> bishopMoves(int[] board, int position, List<Integer> cordsSelf, List<Integer> cordsEnemy) {
        List<Integer> moves = new ArrayList<>();

        final int MOVESUP = movesUpForPos(position);
        final int MOVESDOWN = movesDownForPos(position);
        final int MOVESLEFT = movesLeftForPos(position);
        final int MOVESRIGHT = movesRightForPos(position);


        // +9 | left up
        int movesLeftUp = Math.min(MOVESLEFT, MOVESUP);
        moves.addAll(movesInLine(movesLeftUp, 9, position, cordsSelf, cordsEnemy));


        // +7 | right up
        int movesRightUP = Math.min(MOVESRIGHT, MOVESUP);
        moves.addAll(movesInLine(movesRightUP, 7, position, cordsSelf, cordsEnemy));


        // -7 | left down
        int movesLeftDown = Math.min(MOVESLEFT, MOVESDOWN);
        moves.addAll(movesInLine(movesLeftDown, -7, position, cordsSelf, cordsEnemy));

        // -9 | right down
        int movesRightDown = Math.min(MOVESRIGHT, MOVESDOWN);
        moves.addAll(movesInLine(movesRightDown, -9, position, cordsSelf, cordsEnemy));


        return moves;
    }


    public static List<Integer> queenMoves(int[] board, int position) {
        List<List<Integer>> pieces = findPiecesLists(board, position);
        return queenMoves(board, position, pieces.get(0), pieces.get(1));
    }

    public static List<Integer> queenMoves(int[] board, int position, List<Integer> cordsSelf, List<Integer> cordsEnemy) {
        List<Integer> moves = rookMoves(board, position, cordsSelf, cordsEnemy);
        moves.addAll(bishopMoves(board, position, cordsSelf, cordsEnemy));
        return moves;
    }


    public static List<Integer> knightMoves(int[] board, int position) {
        List<List<Integer>> pieces = findPiecesLists(board, position);

        return knightMoves(board, position, pieces.get(0), pieces.get(1));
    }

    public static List<Integer> knightMoves(int[] board, int position, List<Integer> cordsSelf, List<Integer> cordsEnemy) {
        List<Integer> moves = new ArrayList<>();

        // up
        if (movesUpForPos(position) >= 2 ) {

            // left
            if (movesLeftForPos(position) >= 1 && !cordsSelf.contains(position + 17)) {
                moves.add(position + 17);
            }

            // right
            if (movesRightForPos(position) >= 1 && !cordsSelf.contains(position + 15)) {
                moves.add(position + 15);
            }
        }

        // left
        if (movesLeftForPos(position) >= 2) {

            // up
            if (movesUpForPos(position) >= 1 && !cordsSelf.contains(position + 10)) {
                moves.add(position + 10);
            }

            // down
            if (movesDownForPos(position) >= 1 && !cordsSelf.contains(position - 6)) {
                moves.add(position - 6);
            }
        }

        // down
        if (movesDownForPos(position) >= 2) {

            // left
            if (movesLeftForPos(position) >= 1 && !cordsSelf.contains(position - 15)) {
                moves.add(position - 15);
            }

            // right
            if (movesRightForPos(position) >= 1 && !cordsSelf.contains(position - 17)) {
                moves.add(position - 17);
            }
        }

        // right
        if (movesRightForPos(position) >= 2) {

            // up
            if (movesUpForPos(position) >= 1 && !cordsSelf.contains(position + 6)) {
                moves.add(position + 6);
            }

            // down
            if (movesDownForPos(position) >= 1 && !cordsSelf.contains(position - 10)) {
                moves.add(position - 10);
            }
        }


        return moves;
    }




    public static List<Integer> movesInLine(int count, int direction, int position, List<Integer> cordsSelf, List<Integer> cordsEnemy) {
        List<Integer> moves = new ArrayList<>();

        while (count > 0) {
            position += direction;

            if (cordsSelf.contains(position)) {
                break;
            }

            moves.add(position);

            if (cordsEnemy.contains(position)) {
                break;
            }

            count--;
        }
        
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

    private static int movesUpForPos(int position) {
        return 7 - (position / 8);
    }

    private static int movesDownForPos(int position) {
        return position / 8;
    }

    private static int movesRightForPos(int position) {
        return position % 8;
    }

    private static int movesLeftForPos(int position) {
        return 7 - (position % 8);
    }
}
