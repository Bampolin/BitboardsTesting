package chess.bot.board;

import java.util.ArrayList;
import java.util.List;

public class PiecesListBoard {
    private Board board;

    public PiecesListBoard(Board board) {
        setBoard(board);
    }

    public PiecesListBoard(int[] board) {
        setBoard(new Board(board));
    }

    public List<Integer> getWhitePiecesCords() {
        List<Integer> cords = new ArrayList<>();

        for (int i = 0; i < 64; i++ ) {
            if (Piece.isWhite(board.getBoard()[i])) {
                cords.add(i);
            }
        }

        return cords;
    }

    public List<Integer> getBlackPiecesCords() {
        List<Integer> cords = new ArrayList<>();

        for (int i = 0; i < 64; i++ ) {
            if (Piece.isBlack(board.getBoard()[i])) {
                cords.add(i);
            }
        }

        return cords;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}