package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardStateOneColor {
    private long pawns;
    private long bishops;
    private long knights;
    private long rooks;
    private long queens;
    private long king;

    public BoardStateOneColor copy() {
        BoardStateOneColor result = new BoardStateOneColor();
        result.setPawns(pawns);
        result.setKing(king);
        result.setBishops(bishops);
        result.setKnights(knights);
        result.setQueens(queens);
        result.setRooks(rooks);

        return result;
    }

    public static boolean isSet(long bitboard, int x, int y) {
        // Berechnung der Position im Bitboard basierend auf x und y.
        int position = (7 - y) * 8 + x;
        // Überprüfen, ob das Bit an der berechneten Position gesetzt ist.
        return (bitboard & (1L << position)) != 0;
    }
}