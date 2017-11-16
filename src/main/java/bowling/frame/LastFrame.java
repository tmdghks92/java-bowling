package bowling.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.frame.state.State;
import bowling.frame.state.lastframe.LastFrameReady;

public class LastFrame extends Frame {
	
	private static final Logger log = LoggerFactory.getLogger(LastFrame.class);


	private State state;

	public LastFrame(int no) {
		super(no);
		state = new LastFrameReady();
	}

	public static Frame create(int no) {
		return new LastFrame(no);
	}

	@Override
	public Frame bowl(int score) {
		if (score > 10 || score < 0) {
			log.debug(" 0~10 사이의 값을 입력하세요.");
			return this;
		}
		this.state = this.state.bowl(score);
		return this;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public Frame getNext() {
		return null;
	}
}
