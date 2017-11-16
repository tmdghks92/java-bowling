package bowling.score;

import java.util.ArrayList;
import java.util.List;

import bowling.frame.Frame;
import bowling.frame.state.BowlingEnd;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameSecond;
import bowling.frame.state.normalframe.NormalFrameSpare;
import bowling.frame.state.normalframe.NormalFrameStrike;

public class Score {
	private final int SPARE = 1;
	private final int STRIKE = 2;

	private List<Integer> scores;

	public Score(Frame frame) {
		scores = new ArrayList<>();
		calculateScore(frame);
	}

	public List<Integer> get() {
		return scores;
	}

	private void calculateScore(Frame frame) {
		Frame nowFrame = frame;
		while (!isEmpty(nowFrame)) {
			State state = nowFrame.getState();
			isState(nowFrame, state);
			nowFrame = nowFrame.getNext();
		}
	}

	private boolean isEmpty(Frame frame) {
		return frame == null;
	}

	private void isState(Frame frame, State state) {
		if (isStrike(state)) {
			scores.add(calculateStrike(frame));
		} else if (isSpare(state)) {
			scores.add(calculateSpare(frame));

		} else if (isMiss(state)) {
			scores.add(calculateMiss(frame));

		} else if (isLastFrame(state)) {
			scores.add(calculateLastFrame(frame));
		}
	}

	private Integer calculateLastFrame(Frame frame) {
		int temp = scores.get(scores.size() - 1);
		State state = frame.getState();
		return temp + state.getFinalScore();
	}

	private Integer calculateMiss(Frame frame) {
		int temp = getBeforeBowlingScore();
		State state = frame.getState();
		return temp + state.getFinalScore();
	}

	private Integer calculateSpare(Frame frame) {
		Frame nowFrame = frame;
		int temp = getBeforeBowlingScore();
		try {
			temp = spare(nowFrame, temp);
		} catch (NullPointerException e) {
			return null;
		}
		return temp;
	}

	private Integer calculateStrike(Frame frame) {
		Frame nowFrame = frame;
		int temp = getBeforeBowlingScore();
		try {
			temp = strike(nowFrame, temp);
		} catch (NullPointerException e) {
			return null;
		}
		return temp;
	}

	private int spare(Frame nowFrame, int temp) {
		State state = nowFrame.getState();
		temp += state.getFinalScore();
		nowFrame = nowFrame.getNext();
		state = nowFrame.getState();
		temp += state.getFirstScore();
		return temp;
	}

	private int strike(Frame nowFrame, int temp) {
		State state = nowFrame.getState();
		temp += state.getFinalScore();
		nowFrame = nowFrame.getNext();
		state = nowFrame.getState();
		if (isStrike(state)) {
			temp += state.getFinalScore();
			nowFrame = nowFrame.getNext();
			state = nowFrame.getState();
			if (isStrike(state)) {
				return temp += state.getFinalScore();
			}
			return temp += state.getFirstScore();
		}
		temp += state.getFirstScore() + state.getSecondScore();
		return temp;
	}

	private int getBeforeBowlingScore() {
		if (scores.size() == 0) {
			return 0;
		}
		return scores.get(scores.size() - 1);
	}

	private boolean isStrike(State state) {
		return state instanceof NormalFrameStrike;
	}

	private boolean isSpare(State state) {
		return state instanceof NormalFrameSpare;
	}

	private boolean isMiss(State state) {
		return state instanceof NormalFrameSecond;
	}

	private boolean isLastFrame(State state) {
		return state instanceof BowlingEnd;
	}
}
