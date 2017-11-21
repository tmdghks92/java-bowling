package bowling.frame.state.lastframe;

import bowling.frame.state.BowlingEnd;

public class LastFrameSecond extends BowlingEnd {

	public LastFrameSecond(int firstScore, int secondScore) {
		super(firstScore, secondScore, 0);

	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getFirstScore());
		stringBuilder.append("|");
		stringBuilder.append(getSecondScore());
		return stringBuilder.toString();
	}

}
