package bowling.frame.state.lastframe;

import bowling.frame.state.Running;
import bowling.frame.state.State;
import bowling.score.Score;

public class LastFrameStrike extends Running {

	public LastFrameStrike(int firstScore, int secondScore) {
		super(firstScore, secondScore);
	}

	@Override
	public State bowl(int score) {
		return new Bonuce(getFirstScore(), score);
	}

	@Override
	public String getPresentStringScore() {
		return "X";
	}
}
