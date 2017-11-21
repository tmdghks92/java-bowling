package bowling.frame.state;

public abstract class BowlingEnd implements State {
	private int firstScore;
	private int secondScore;
	private int thirdScore;

	public BowlingEnd(int firstScore, int secondScore, int thirdScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
	}

	@Override
	public State bowl(int score) {
		throw new IllegalArgumentException("");
	}

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public int getThirdScore() {
		return thirdScore;
	}

	@Override
	public int getScore() {
		return firstScore + secondScore + thirdScore;
	}
}
