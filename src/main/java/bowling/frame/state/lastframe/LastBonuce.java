package bowling.frame.state.lastframe;

import bowling.frame.state.BowlingEnd;

public class LastBonuce extends BowlingEnd {

	public LastBonuce(int firstScore, int secondScore, int thirdScore) {
		super(firstScore, secondScore, thirdScore);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getFirstScore());
		stringBuilder.append("|");
		stringBuilder.append(getSecondScore());
		stringBuilder.append("|");
		stringBuilder.append(getThirdScore());
		return stringBuilder.toString();
	}
}
