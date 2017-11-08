package new_ladder;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import new_ladder.ladder.Ladder;
import new_ladder.ladder.Low;
import new_ladder.ladder.Route;

public class LadderTest {

	@Test
	public void 사다리초기화() {
		Ladder ladder = new Ladder(5, 5);
		assertEquals(5, ladder.size());
	}

	@Test
	public void 사다리_출력하기() throws Exception {
		Ladder ladder = new Ladder(5, 5);
		List<Low> temp = ladder.getLadder();
		for (Low low : temp) {
			for (Route route : low.getLow()) {
				System.out.print("|");
				if (route.getRoute()) {
					System.out.print(route);
				}
			}
			System.out.println();
		}
	}

}
