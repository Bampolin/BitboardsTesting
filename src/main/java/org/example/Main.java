package org.example;

import java.util.Locale;

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

        BoardStateOneColor blackManipulated = black.copy();
        blackManipulated.remove(0, 6);


        printBitboard(blackManipulated.orAll());
        System.out.println("----------------------");
        printBitboard(whiteManipulated.orAll());
        System.out.println("----------------------");

        long start = System.nanoTime();
        System.out.println(whiteManipulated.findPseudoValidRookMoves(blackManipulated.orAll()));
        long end = System.nanoTime();

        System.out.println(" Rook moves took " + formatNanos(end - start) + " nano seconds");






    }


    public static void printBitboard(long bitboard) {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                // Berechne die Position im Bitboard
                int position = 63 - (rank * 8 + file);
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

    public static String formatNanos(long nanos) {
        String formattedNumber = String.format(Locale.GERMAN, "%,d", nanos);

        formattedNumber = formattedNumber.replace('.', ' ');

        return formattedNumber;
    }
}