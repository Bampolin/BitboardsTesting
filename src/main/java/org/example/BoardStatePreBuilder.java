package org.example;

public class BoardStatePreBuilder {
    public static BoardStateOneColor startPositionWhite() {
        BoardStateOneColor result = new BoardStateOneColor();

        result.setKing(     0b0000000000000000000000000000000000000000000000000000000000010000L);
        result.setQueens(   0b0000000000000000000000000000000000000000000000000000000000001000L);
        result.setRooks(    0b0000000000000000000000000000000000000000000000000000000010000001L);
        result.setBishops(  0b0000000000000000000000000000000000000000000000000000000000100100L);
        result.setKnights(  0b0000000000000000000000000000000000000000000000000000000001000010L);
        result.setPawns(    0b0000000000000000000000000000000000000000000000001111111100000000L);

        return result;
    }

    public static BoardStateOneColor startPositionBlack() {
        BoardStateOneColor result = new BoardStateOneColor();

        result.setKing(     0b0001000000000000000000000000000000000000000000000000000000000000L);
        result.setQueens(   0b0000100000000000000000000000000000000000000000000000000000000000L);
        result.setRooks(    0b1000000100000000000000000000000000000000000000000000000000000000L);
        result.setBishops(  0b0010010000000000000000000000000000000000000000000000000000000000L);
        result.setKnights(  0b0100001000000000000000000000000000000000000000000000000000000000L);
        result.setPawns(    0b0000000011111111000000000000000000000000000000000000000000000000L);

        return result;
    }
}