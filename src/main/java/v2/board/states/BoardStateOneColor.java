package v2.board.states;

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

    public long orAll() {
        return pawns | knights | bishops | rooks | queens | king;
    }

    public long andAll() {
        // only for testing, should always be only 0s
        return pawns & knights & bishops & rooks & queens & king;
    }

    public long[] allAsArray() {
        return new long[]{king, queens, rooks, bishops, knights, pawns};
    }
}