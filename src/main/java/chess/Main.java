package chess;

import chess.bot.board.Board;
import chess.bot.board.Piece;
import chess.bot.board.PiecesListBoard;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setSquare(1, Piece.WHITE | Piece.KING);
        board.setSquare(2, Piece.WHITE | Piece.ROOK);
        board.setSquare(4, Piece.WHITE | Piece.QUEEN);
        board.setSquare(7, Piece.WHITE | Piece.ROOK);

        board.setSquare(8, Piece.WHITE | Piece.PAWN);
        board.setSquare(9, Piece.WHITE | Piece.PAWN);
        board.setSquare(10, Piece.WHITE | Piece.PAWN);
        board.setSquare(11, Piece.WHITE | Piece.PAWN);
        board.setSquare(12, Piece.WHITE | Piece.PAWN);
        board.setSquare(31, Piece.WHITE | Piece.PAWN);

        board.setSquare(57, Piece.BLACK | Piece.KING);
        board.setSquare(58, Piece.BLACK | Piece.ROOK);
        board.setSquare(60, Piece.BLACK | Piece.QUEEN);
        board.setSquare(63, Piece.BLACK | Piece.BISHOP);
        board.setSquare(62, Piece.BLACK | Piece.BISHOP);
        board.setSquare(44, Piece.BLACK | Piece.KNIGHT);

        board.setSquare(55, Piece.BLACK | Piece.PAWN);
        board.setSquare(36, Piece.BLACK | Piece.PAWN);
        board.setSquare(43, Piece.BLACK | Piece.PAWN);
        board.setSquare(50, Piece.BLACK | Piece.PAWN);
        board.setSquare(49, Piece.BLACK | Piece.PAWN);
        board.setSquare(48, Piece.BLACK | Piece.PAWN);


        printBoard(board);

        testPiecesList(new PiecesListBoard(board));
    }



    private static void testPieces() {
        /*
white king  	0000    1
white queen  	0001    2
white rook  	0010    3
white bishop	0011    4
white knight	0100    5
white pawn  	0101    6

black king  	1000    9
black queen  	1001    10
black rook  	1010    11
black bishop	1011    12
black knight	1100    13
black pawn   	1101    14
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

    public static void testPiecesList(PiecesListBoard board) {
        System.out.println("white: ");
        System.out.println(board.getWhitePiecesCords());

        System.out.println("black: ");
        System.out.println(board.getBlackPiecesCords());
    }
}