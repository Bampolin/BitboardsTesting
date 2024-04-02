package org.example;

public class Main {
    public static void main(String[] args) {
        BoardStateOneColor white = BoardStatePreBuilder.startPositionWhite();
        BoardStateOneColor black = BoardStatePreBuilder.startPositionBlack();

        BoardStateOneColor whiteManipulated = white.copy();
        whiteManipulated.remove(0, 1);
        whiteManipulated.remove(1, 0);
        whiteManipulated.remove(2, 0);
        whiteManipulated.remove(3, 0);
        whiteManipulated.remove(4, 0);
        whiteManipulated.remove(5, 0);
        whiteManipulated.remove(6, 0);
        whiteManipulated.remove(7, 0);

        BoardStateOneColor blackManipulated = black.copy();
        blackManipulated.remove(0, 6);



        printBitboard(blackManipulated.orAll());
        System.out.println("----------------------");
        printBitboard(whiteManipulated.orAll());

        System.out.println(whiteManipulated.findPseudoValidRookMoves(5, 4, blackManipulated.orAll()));

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