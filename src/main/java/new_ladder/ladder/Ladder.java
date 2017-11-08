package new_ladder.ladder;

import java.util.List;

public class Ladder {
	List<Low> ladder;

	public Ladder(int low, int column) {
		createLadder(low, column);
	}

	private void createLadder(int low, int column) {
		ladder = new Column(low, column).getColumn();
	}

	public int size() {
		return ladder.size();
	}

	public List<Low> getLadder() {
		return ladder;
	}

}
