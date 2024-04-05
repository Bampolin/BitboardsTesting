package org.example.chat_beispiele;

public class BitboardHelper {

    public static long setPositionRowAndColumn(long board, int position) {
        final long rowMask = 0xFFL; // 8 Bits in einer Reihe gesetzt (255 in dezimal)
        final long columnMask = 0x0101010101010101L; // Ein Bit in jeder Reihe gesetzt (für die erste Spalte)

        // Berechne x und y Koordinaten
        int x = position % 8;
        int y = position / 8;

        // Erstelle Masken für die spezifische Spalte und Reihe
        long rowBitmask = rowMask << (8 * y); // Verschiebe die Reihe an die richtige Position
        long columnBitmask = columnMask << x; // Verschiebe die Spalte an die richtige Position

        // Kombiniere beide Masken, um die Spalte und Reihe zu setzen
        board |= rowBitmask | columnBitmask;

        return board;
    }

    public static void main(String[] args) {
        int position = 27; // Beispielposition
        long board = 0L; // Starte mit einem leeren Bitboard
        board = setPositionRowAndColumn(board, position);

        // Für Demonstrationszwecke: Ausgabe des Bitboards in binärer Form
        for (int i = 63; i >= 0; i--) {
            System.out.print((board & (1L << i)) != 0 ? "1" : "0");
            if (i % 8 == 0) System.out.println(); // Neue Zeile nach jeder Reihe
        }
    }
}

