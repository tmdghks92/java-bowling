package bowling.frame.state.normalframe;

import bowling.frame.state.End;

public class NormalFrameSecond extends End {

	public NormalFrameSecond(int firstScore, int secondScore) {
		super(firstScore, secondScore);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		if (getSecondScore() == 0) {
			stringBuilder.append(getFirstScore());
			stringBuilder.append("|-");
			return stringBuilder.toString();
		}
		stringBuilder.append(getFirstScore());
		stringBuilder.append("|");
		stringBuilder.append(getSecondScore());
		return stringBuilder.toString();
	}
}
