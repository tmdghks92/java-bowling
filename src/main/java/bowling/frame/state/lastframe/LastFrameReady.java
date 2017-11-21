package bowling.frame.state.lastframe;

import bowling.exception.BowlingException;
import bowling.frame.state.State;
import bowling.score.Score;

public class LastFrameReady implements State {

	@Override
	public State bowl(int score) {
		if (score == 10) {
			return new LastFrameStrike(10, 0);
		}
		return new LastFrameFirst(score);
	}

	@Override
	public String getPresentStringScore() {
		return "      |";
	}

	@Override
	public int getScore() {
		throw new BowlingException("ready 상태에서는 점수를 가져 올수 없습니다.");
	}
	
	@Override
	public int getScore(int count) {
		throw new BowlingException("ready 상태에서는 점수를 가져 올수 없습니다.");
	}
	
	@Override
	public Score getScore(Score score) {
		throw new BowlingException("ready 상태에서는 점수를 가져 올수 없습니다.");
	}
}
