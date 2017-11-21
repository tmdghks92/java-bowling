package bowling.frame.state;

import bowling.score.Score;

public abstract class End implements State {

	private int firstScore;
	private int secondScore;

	public End(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public State bowl(int score) {
		throw new IllegalArgumentException("");
	}

	@Override
	public int getScore() {
		return firstScore + secondScore;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	@Override
	public int getScore(int count) {
		if (count == 2) {
			return getScore();
		}
		return firstScore;
	}

	@Override
	public Score getScore(Score score) {
		score.addScore(getFirstScore());
		if (!score.isEnd()) {
			score.addScore(getSecondScore());
		}	
		return score;
	}
}
