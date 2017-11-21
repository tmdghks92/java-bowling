package bowling.frame.state.normalframe;

import bowling.exception.BowlingException;
import bowling.frame.state.End;
import bowling.score.Score;

public class NormalFrameStrike extends End {

	public NormalFrameStrike(int i, int j) {
		super(i, j);
	}

	@Override
	public String getPresentStringScore() {
		return "X";
	}

	@Override
	public int getSecondScore() {
		throw new BowlingException("strike 상태에서는 두 번째 점수를 가져 올수 없습니다.");
	}

	@Override
	public Score getScore(Score score) {
		score.addScore(getFirstScore());
		return score;
	}

}
