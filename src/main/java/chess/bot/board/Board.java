package chess.bot.board;

public class Board {
    private int [] board;

    public Board() {
        board = new int[64];
    }

    public Board(int[] board) {
        setBoard(board);
    }

    public void setSquare(int square, int value) {
        board[square] = value;
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }
}