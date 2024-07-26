package v2.board.states;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullBoardState {
    private BoardStateOneColor white;
    private BoardStateOneColor black;

    public FullBoardState deepCopy() {
        FullBoardState result = new FullBoardState();

        result.setWhite(getWhite().copy());
        result.setBlack(getBlack().copy());

        return result;
    }




}