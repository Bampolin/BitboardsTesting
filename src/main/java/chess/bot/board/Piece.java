package chess.bot.board;

public class Piece {
    public static final int KING = 1;
    public static final int QUEEN = 2;
    public static final int ROOK = 3;
    public static final int BISHOP = 4;
    public static final int KNIGHT = 5;
    public static final int PAWN = 6;

    public static final int WHITE = 0;
    public static final int BLACK = 8;


    public static boolean isBlack(int code) {
        if (code > 8) {
            return true;
        }
        return false;
    }

    public static boolean isWhite(int code) {
        return code != 0 && !isBlack(code);
    }

    public static int getPieceType(int code) {
        return 0b0111 & code;
    }

    // piece types
    public static boolean isKing(int code) {
        return getPieceType(code) == KING;
    }

    public static boolean isQueen(int code) {
        return getPieceType(code) == QUEEN;
    }

    public static boolean isRook(int code) {
        return getPieceType(code) == ROOK;
    }

    public static boolean isBishop(int code) {
        return getPieceType(code) == BISHOP;
    }

    public static boolean isKnight(int code) {
        return getPieceType(code) == KNIGHT;
    }

    public static boolean isPawn(int code) {
        return getPieceType(code) == PAWN;
    }
}