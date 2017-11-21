package bowling.frame.state.normalframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class NormalFrameFirst extends Running {

	public NormalFrameFirst(int score) {
		super(score, 0);
	}

	@Override
	public State bowl(int score) {
		if (getFirstScore() + score == 10) {
			return new NormalFrameSpare(getFirstScore(), score);
		}
		return new NormalFrameSecond(getFirstScore(), score);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getFirstScore());
		return stringBuilder.toString();
	}
}
