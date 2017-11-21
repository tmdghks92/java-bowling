package bowling.score;

public class Score {
	private int score;
	private int count;

	private Score(int score, int count) {
		this.score = score;
		this.count = count;
	}

	public void addScore(int score) {
		this.score += score;
		this.count--;
	}

	public boolean isEnd() {
		return this.count == 0;
	}

	public int getScore() {
		return score;
	}

	public static Score createMiss(int score) {
		return new Score(score, 0);
	}

	public static Score createSpare(int score) {
		return new Score(score, 1);
	}

	public static Score createStrike(int score) {
		return new Score(score, 2);
	}
}
