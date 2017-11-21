package bowling.frame.state;

import bowling.score.Score;

public interface State {
	public State bowl(int score);

	public String getPresentStringScore();

	public int getScore();

	public Score getScore(Score score);
}
