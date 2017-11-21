package bowling.score;

import java.util.ArrayList;
import java.util.List;

import bowling.exception.BowlingException;
import bowling.frame.Frame;

public class Scores {

	private List<Integer> scores;

	public Scores(Frame frame) {
		scores = new ArrayList<>();
		calculateScore(frame);
	}

	public List<Integer> get() {
		return scores;
	}

	private void calculateScore(Frame frame) {
		Frame next = frame;
		while (!isEmpty(next)) {
			try {
				scores.add(getBeforeBowlingScore() + next.getScore().getScore());
				next = next.getNext();
			} catch (BowlingException | NullPointerException e) {
				return;
			}
		}
	}

	private boolean isEmpty(Frame frame) {
		return frame == null;
	}

	private int getBeforeBowlingScore() {
		if (scores.size() == 0) {
			return 0;
		}
		return scores.get(scores.size() - 1);
	}
}
