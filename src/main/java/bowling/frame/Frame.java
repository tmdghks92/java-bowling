package bowling.frame;

import bowling.frame.state.BowlingEnd;
import bowling.frame.state.State;
import bowling.frame.state.normalframe.NormalFrameSecond;
import bowling.frame.state.normalframe.NormalFrameSpare;
import bowling.frame.state.normalframe.NormalFrameStrike;
import bowling.result.Result;
import bowling.score.Score;

public abstract class Frame {
	private int no;

	public Frame(int no) {
		this.no = no;
	}

	public int getNo() {
		return this.no;
	}

	public Frame nextFrame() {
		if (no == 9) {
			return LastFrame.create(no + 1);
		}
		return NormalFrame.create(no + 1);
	}

	abstract public Frame bowl(int score);

	abstract public State getState();

	abstract public Frame getNext();

	abstract public Integer getScore();

	public Result result(Score score) {
		return new Result(this, score);
	}

	public Score score() {
		return new Score(this);
	}

	public boolean isStrike() {
		return this.getState() instanceof NormalFrameStrike;
	}

	public boolean isSpare() {
		return this.getState() instanceof NormalFrameSpare;
	}

	public boolean isSecond() {
		return this.getState() instanceof NormalFrameSecond;
	}

	public boolean isLastFrame() {
		return this.getState() instanceof BowlingEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		return no == other.no;
	}
}