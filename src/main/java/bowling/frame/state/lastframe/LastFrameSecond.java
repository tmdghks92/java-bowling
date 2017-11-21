package bowling.frame.state.lastframe;

import bowling.exception.BowlingException;
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

	@Override
	public int getThirdScore() {
		throw new BowlingException("Non-Bonuce 상태에서는 세 번째 점수를 가져 올수 없습니다.");
	}
}
