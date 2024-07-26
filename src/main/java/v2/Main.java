package v2;

import v2.board.states.FullBoardState;
import v2.board.states.util.BoardStatePreBuilder;

public class Main {
    public static void main(String[] args) {
        FullBoardState board = new FullBoardState();

        board.setWhite(BoardStatePreBuilder.startPositionWhite());
        board.setBlack(BoardStatePreBuilder.startPositionBlack());

        for (long l : board.getWhite().allAsArray()) {
            System.out.println("---------------------");
            System.out.println(l);
        }

        System.out.println("==========================");

        for (long l : board.getBlack().allAsArray()) {
            System.out.println("---------------------");
            System.out.println(l);
        }

    }
}