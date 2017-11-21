package bowling.frame.state;

public abstract class Running implements State {

	private int firstScore;
	private int secondScore;

	public Running(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	abstract public State bowl(int score);

	public abstract String getPresentStringScore();

	public int getFirstScore() {
		return firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	@Override
	public int getScore() {
		return firstScore + secondScore;
	}
}
