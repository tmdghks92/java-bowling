package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;
import bowling.score.Score;

public class LastFrameSpare extends Running {

	public LastFrameSpare(int firstScore, int secondScore) {
		super(firstScore, secondScore);
	}

	@Override
	public State bowl(int score) {
		return new LastBonuce(getFirstScore(), getSecondScore(), score);
	}

	@Override
	public String getPresentStringScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getFirstScore());
		stringBuilder.append("|/");
		return stringBuilder.toString();
	}

	@Override
	public Score getScore(Score score) {
		score.addScore(getFirstScore());
		score.addScore(getSecondScore());
		return score;
	}
}
