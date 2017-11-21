package bowling.frame.state.normalframe;

import bowling.frame.state.End;

public class NormalFrameSpare extends End {

	public NormalFrameSpare(int firstScore, int secondScore) {
		super(firstScore, secondScore);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getFirstScore());
		stringBuilder.append("|/");
		return stringBuilder.toString();
	}

}
