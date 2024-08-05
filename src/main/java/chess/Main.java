package chess;

import chess.bot.board.Board;
import chess.bot.board.Piece;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setSquare(4, Piece.WHITE | Piece.BISHOP);

        printBoard(board);

    }



    private static void testPieces() {
        /*
white king  	0000    0
white queen  	0001    1
white rook  	0010    2
white bishop	0011    3
white knight	0100    4
white pawn  	0101    5

black king  	1000    8
black queen  	1001    9
black rook  	1010    10
black bishop	1011    11
black knight	1100    12
black pawn   	1101    13
         */

        int [] pieces = {Piece.KING, Piece.QUEEN, Piece.ROOK, Piece.BISHOP, Piece.KNIGHT, Piece.PAWN};
        int [] colors = {Piece.WHITE, Piece.BLACK};


        int code;
        for (int color : colors) {
            for (int piece : pieces) {
                code = color | piece;

                if (Piece.isBlack(code)) {
                    System.out.print("Black ");
                } else {
                    System.out.print("White ");
                }

                printPieceType(code);
                System.out.print(" | ");
                System.out.println(code);
            }
        }
    }

    public static void printPieceType(int code) {
        if (Piece.isKing(code)) {
            System.out.print("King  ");
        } else if (Piece.isQueen(code)) {
            System.out.print("Queen ");
        } else if (Piece.isRook(code)) {
            System.out.print("Rook  ");
        } else if (Piece.isBishop(code)) {
            System.out.print("Bishop");
        } else if (Piece.isKnight(code)) {
            System.out.print("Knight");
        } else if (Piece.isPawn(code)) {
            System.out.print("Pawn  ");
        } else {
            System.out.print("unknown");
        }
    }

    public static void printBoard(Board board) {
        int [] arr = board.getBoard();

        for (int i = 63; i >= 0; i--) {
            System.out.printf("%02d ", arr[i]);
            if ((i) % 8 == 0) {
                System.out.println();
            }
        }
    }
}