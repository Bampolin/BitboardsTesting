package org.example;

public class Main {
    public static void main(String[] args) {
        long whitePawns     = 0b0000000000000000000000000000000000000000000000001111111100000000L;
        long whiteRooks     = 0b0000000000000000000000000000000000000000000000000000000010000001L;
        long whiteKnights   = 0b0000000000000000000000000000000000000000000000000000000001000010L;
        long whiteBishops   = 0b0000000000000000000000000000000000000000000000000000000000100100L;
        long whiteQueen     = 0b0000000000000000000000000000000000000000000000000000000000010000L;
        long whiteKing      = 0b0000000000000000000000000000000000000000000000000000000000001000L;


        long blackPawns = 0b0000000011111111000000000000000000000000000000000000000000000000L;


        long allWhitePieces = whiteBishops | whiteKnights | whiteKing | whiteQueen | whitePawns | whiteRooks;

        System.out.println("----------------------");
        printBitboard(allWhitePieces);
        System.out.println("----------------------");
        long whiteMinorPieces = whiteKnights | whiteBishops;
        printBitboard(whiteMinorPieces);
        System.out.println("----------------------");


        long testBoard      = 0b0000000000000000000000000000000000000000000000000000000000000000L;
        testBoard = BitboardUtil.setBit(testBoard, true, 0, 0);
        testBoard = BitboardUtil.setBit(testBoard, true, 1, 4);
        testBoard = BitboardUtil.setBit(testBoard, true, 1, 7);
        testBoard = BitboardUtil.setBit(testBoard, true, 7, 7);
        printBitboard(testBoard);





    }


    public static void printBitboard(long bitboard) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // Berechne die Position im Bitboard
                int position = 63 - (row * 8 + col);
                // Prüfe, ob das Bit an der Position gesetzt ist
                if ((bitboard & (1L << position)) != 0) {
                    System.out.print("1  ");
                } else {
                    System.out.print("0  ");
                }
            }
            // Zeilenumbruch nach jeder Zeile
            System.out.println();
        }
        System.out.println();
    }
}