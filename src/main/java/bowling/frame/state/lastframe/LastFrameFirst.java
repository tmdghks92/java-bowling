package bowling.frame.state.lastframe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.state.Running;
import bowling.frame.state.State;

public class LastFrameFirst extends Running {
	
	private static final Logger log = LoggerFactory.getLogger(LastFrameFirst.class);


	private int firstScore;

	public LastFrameFirst(int score) {
		this.firstScore = score;
	}

	@Override
	public State bowl(int score) {
		if (firstScore + score > 10) {
			log.debug(" 쓰러진 핀의 수가 10이 넘을 수 없습니다. ");
			return this;
		}
		if (firstScore + score == 10) {
			return new LastFrameSpare(firstScore, score);
		}
		return new LastFrameSecond(firstScore, score);
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		return stringBuilder.toString();
	}

	@Override
	public int getFirstScore() {
		return firstScore;
	}

	@Override
	public int getSecondScore() {
		return 0;
	}

}
