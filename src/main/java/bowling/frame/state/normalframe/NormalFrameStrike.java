package bowling.frame.state.normalframe;

import bowling.frame.state.End;

public class NormalFrameStrike extends End {

	public NormalFrameStrike(int i, int j) {
		super(i, j);
	}

	@Override
	public String getPresentStringScore() {
		return "X";
	}
}
