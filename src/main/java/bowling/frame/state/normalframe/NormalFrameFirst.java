package bowling.frame.state.normalframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;
import bowling.score.Score;

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

	@Override
	public Score getScore(Score score) {
		score.addScore(getFirstScore());
		return score;
	}
}
