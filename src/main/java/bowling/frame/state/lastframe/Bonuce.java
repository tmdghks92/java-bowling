package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class Bonuce extends Running {

	public Bonuce(int firstScore, int secondScore) {
		super(firstScore, secondScore);
	}

	@Override
	public State bowl(int score) {
		return new LastBonuce(getFirstScore(), getSecondScore(), score);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("X|");
		if (getSecondScore() == 10) {
			stringBuilder.append("X");
			return stringBuilder.toString();
		}
		if (getSecondScore() == 0) {
			stringBuilder.append("-");
			return stringBuilder.toString();
		}
		stringBuilder.append(getSecondScore());
		return stringBuilder.toString();
	}
}
