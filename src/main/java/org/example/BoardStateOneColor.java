package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardStateOneColor {
    private long pawns;
    private long knights;
    private long bishops;
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
}