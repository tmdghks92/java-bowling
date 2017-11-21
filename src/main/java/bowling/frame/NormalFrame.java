package bowling.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.exception.BowlingException;
import bowling.frame.state.End;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameReady;

public class NormalFrame extends Frame {
	private static final Logger log = LoggerFactory.getLogger(NormalFrame.class);

	private State state;
	private Frame next;

	private int frameScore;

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
	public Integer getScore() {
		try {
			if (this.isSecond()) {
				return calculateScore(this, 0, frameScore);
			}
			if (this.isSpare()) {
				return calculateScore(this, 1, frameScore);
			}
			if (this.isStrike()) {
				return calculateScore(this, 2, frameScore);
			}
		} catch (BowlingException e) {
			return null;
		}
		return null;
	}

	private Integer calculateScore(Frame frame, int count, int frameScore) throws BowlingException {
		log.debug("frame score : {}", frameScore);
		State state = frame.getState();
		if (count == 0) {
			return frameScore + state.getScore();
		}
		log.debug("{}", state.getScore());
		return calculateScore(frame.getNext(), count - 1, state.getScore());
	}
}
