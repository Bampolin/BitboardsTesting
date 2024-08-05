package v2.move_generation.pseudo_legal;

import v2.board.states.BoardStateOneColor;

public class RookUtil {
    public static long findMoves(BoardStateOneColor self, BoardStateOneColor other, int pos) {
        long moves = 0;
        long otherOrAll = other.orAll();

        // mögliche Züge (pos): +1, +8, -1, -8


        // up
        // +8, bis das Board vorbei ist (pos <= 63)
        int posUp = pos;

        







        return moves;
    }
}