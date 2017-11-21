package bowling.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.exception.BowlingException;
import bowling.frame.state.End;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameReady;
import bowling.score.Score;

public class NormalFrame extends Frame {
	private static final Logger log = LoggerFactory.getLogger(NormalFrame.class);

	private State state;
	private Frame next;

	public NormalFrame(int no) {
		super(no);
		state = new NormalFrameReady();
	}

	public static Frame create(int no) {
		return new NormalFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		if (score > 10 || score < 0) {
			log.debug(" 0~10 사이의 값을 입력하세요.");
			return this;
		}
		state = this.state.bowl(score);
		if (state instanceof End) {
			next = nextFrame();
			return next;
		}
		return this;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public Frame getNext() {
		return next;
	}

	@Override
	public Score getScore() {
		try {
			if (this.isSecond()) {
				return calculateScore(this, Score.createMiss(this.state.getScore()));
			}
			if (this.isSpare()) {
				return calculateScore(this, Score.createSpare(this.state.getScore()));
			}
			if (this.isStrike()) {
				return calculateScore(this, Score.createStrike(this.state.getScore()));
			}
		} catch (BowlingException e) {
			return null;
		}
		return null;
	}

	private Score calculateScore(Frame frame, Score score) {
		log.debug("frame score : {}", score.getScore());
		log.debug("frame score : {}", score.getCount());
		if (score.isEnd()) {
			return score;
		}
		Frame next = frame.getNext();
		State state = next.getState();
		score = state.getScore(score);
		return calculateScore(next, score);
	}
	// 현재 프레임 점수를 가지는 변수와 카운드를 가지는 변수
}
