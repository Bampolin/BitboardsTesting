package chess.bot.board;

public class Board {
    private int [] board;

    private boolean whiteCastlingLeft;
    private boolean whiteCastlingRight;

    private boolean blackCastlingLeft;
    private boolean blackCastlingRight;
    private int enPassantOnSquare;

    public Board() {
        board = new int[64];
        whiteCastlingLeft = true;
        whiteCastlingRight = true;
        blackCastlingLeft = true;
        blackCastlingRight = true;
        enPassantOnSquare = 0;
    }

    public Board(int[] board) {
        this.board = board;
    }


    //region get/set

    public void setSquare(int square, int value) {
        board[square] = value;
    }

    public void setWhiteCastlingLeft(boolean whiteCastlingLeft) {
        this.whiteCastlingLeft = whiteCastlingLeft;
    }

    public void setWhiteCastlingRight(boolean whiteCastlingRight) {
        this.whiteCastlingRight = whiteCastlingRight;
    }

    public void setBlackCastlingLeft(boolean blackCastlingLeft) {
        this.blackCastlingLeft = blackCastlingLeft;
    }

    public void setBlackCastlingRight(boolean blackCastlingRight) {
        this.blackCastlingRight = blackCastlingRight;
    }

    public void setEnPassantOnSquare(int enPassantOnSquare) {
        this.enPassantOnSquare = enPassantOnSquare;
    }

    public boolean isWhiteCastlingLeft() {
        return whiteCastlingLeft;
    }

    public boolean isWhiteCastlingRight() {
        return whiteCastlingRight;
    }

    public boolean isBlackCastlingLeft() {
        return blackCastlingLeft;
    }

    public boolean isBlackCastlingRight() {
        return blackCastlingRight;
    }

    public int getEnPassantOnSquare() {
        return enPassantOnSquare;
    }

    public int[] getBoard() {
        return board;
    }

    //endregion
}