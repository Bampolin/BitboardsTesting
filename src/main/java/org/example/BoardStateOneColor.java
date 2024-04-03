package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    public List<Move> findPseudoValidRookMoves(int rookPos, long enemyBoard) {
        // enemyBoard is a overlaid Bitboard, representing all enemy pieces
        // valid moves are rookPos +1, -1, +8, -8
        // as long as board not ending / no enemy piece (inclusive) / no friendly piece (exclusive)
        int row = rookPos / 8;
        int file = rookPos - (row * 8);

        return findPseudoValidRookMoves(file, row, enemyBoard);
    }

    public List<Move> findPseudoValidRookMoves(int file, int row, long enemyBoard) {
        List<Move> result = new ArrayList<>();
        int moveSpanRight = 7 - file;
        int moveSpanLeft = 7 - moveSpanRight;
        int moveSpanUp = 7 - row;
        int moveSpanDown = 7 - moveSpanUp;
        long friendlyBoard = orAll();

        // up
        for (int posUp = 0; posUp < moveSpanUp; posUp++) {

            if (BitboardUtil.findBit(friendlyBoard, file, row + posUp + 1)) {
                // occupied by friendly piece -> no more moves
                break;
            }

            result.add(new Move(file, row, file, row + posUp + 1));

            if (BitboardUtil.findBit(enemyBoard, file, row + posUp + 1)) {
                // occupied by enemy piece -> last allowed square
                break;
            }
        }

        // down
        for (int posDown = 0; posDown < moveSpanDown; posDown++) {

            if (BitboardUtil.findBit(friendlyBoard, file, row - posDown - 1)) {
                // occupied by friendly piece -> no more moves
                break;
            }

            result.add(new Move(file, row, file, row - posDown - 1));

            if (BitboardUtil.findBit(enemyBoard, file, row - posDown - 1)) {
                // occupied by enemy piece -> last allowed square
                break;
            }
        }

        // right
        for (int posRight = 0; posRight < moveSpanRight; posRight++) {

            if (BitboardUtil.findBit(friendlyBoard, file + posRight + 1, row)) {
                // occupied by friendly piece -> no more moves
                break;
            }

            result.add(new Move(file, row, file + posRight + 1, row));

            if (BitboardUtil.findBit(enemyBoard, file + posRight + 1, row)) {
                // occupied by enemy piece -> last allowed square
                break;
            }
        }

        // left
        for (int posLeft = 0; posLeft < moveSpanLeft; posLeft++) {

            if (BitboardUtil.findBit(friendlyBoard, file - posLeft - 1, row)) {
                // occupied by friendly piece -> no more moves
                break;
            }

            result.add(new Move(file, row, file - posLeft - 1, row));

            if (BitboardUtil.findBit(enemyBoard, file - posLeft - 1, row)) {
                // occupied by enemy piece -> last allowed square
                break;
            }
        }

        return result;
    }



    public long orAll() {
        return pawns | knights | bishops | rooks | queens | king;
    }

//    public long andAll() {
//        // only for testing, should always be only 0s
//
//        return pawns & knights & bishops & rooks & queens & king;
//    }

    public void remove(int file, int row) {
        // very ugly

        if (BitboardUtil.findBit(king, file, row)) {
            this.king = BitboardUtil.setBit(king, 0, file, row);
            return;
        }

        if (BitboardUtil.findBit(queens, file, row)) {
            this.queens = BitboardUtil.setBit(queens, 0, file, row);
            return;
        }

        if (BitboardUtil.findBit(rooks, file, row)) {
            this.rooks = BitboardUtil.setBit(rooks, 0, file, row);
            return;
        }

        if (BitboardUtil.findBit(bishops, file, row)) {
            this.bishops = BitboardUtil.setBit(bishops, 0, file, row);
            return;
        }

        if (BitboardUtil.findBit(knights, file, row)) {
            this.knights = BitboardUtil.setBit(knights, 0, file, row);
            return;
        }

        this.pawns = BitboardUtil.setBit(pawns, 0, file, row);
    }

//    public long[] allAsArray() {
//        return new long[]{king, queens, rooks, bishops, knights, pawns};
//    }
}