package chess.bot.board;

public class BetterBoard {
    private Board board;

    public BetterBoard() {
    }

    public BetterBoard(Board board) {
        setBoard(board);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}