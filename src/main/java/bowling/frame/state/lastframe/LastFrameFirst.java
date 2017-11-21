package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class LastFrameFirst extends Running {

	public LastFrameFirst(int score) {
		super(score, 0);
	}

	@Override
	public State bowl(int score) {
		if (getFirstScore() + score == 10) {
			return new LastFrameSpare(getFirstScore(), score);
		}
		return new LastFrameSecond(getFirstScore(), score);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getFirstScore());
		return stringBuilder.toString();
	}
}
