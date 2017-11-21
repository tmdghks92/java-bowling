package bowling.score;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import bowling.frame.Frame;
import bowling.frame.NormalFrame;

public class ScoreTest {
	@Test
	public void 스페이_상태일때_점수계산() {
		Frame frame = NormalFrame.create(1);
		Frame next = frame.bowl(1);
		next = next.bowl(9);
		next = next.bowl(3);
		next = next.bowl(3);
		Scores score = frame.score();
		List<Integer> scores = score.get();
		assertEquals((Integer) 13, scores.get(0));
	}

	@Test
	public void 한번_스트라이크() {
		Frame frame = NormalFrame.create(1);
		Frame next = frame.bowl(10);
		next = next.bowl(3);
		next = next.bowl(7);
		next = next.bowl(7);
		next = next.bowl(7);
		next = next.bowl(2);

		Scores score = frame.score();
		List<Integer> scores = score.get();
		assertEquals((Integer) 20, scores.get(0));
	}

	@Test
	public void 이연속_스트라이크() {
		Frame frame = NormalFrame.create(1);
		Frame next = frame.bowl(10);
		next = next.bowl(10);
		next = next.bowl(1);
		next = next.bowl(9);
		next = next.bowl(3);
		next = next.bowl(6);
		Scores score = frame.score();
		List<Integer> scores = score.get();
		assertEquals((Integer) 21, scores.get(0));
	}

	@Test
	public void 삼연속_스트라이크() {
		Frame frame = NormalFrame.create(1);
		Frame next = frame.bowl(10);
		next = next.bowl(10);
		next = next.bowl(10);
		Scores score = frame.score();
		List<Integer> scores = score.get();
		assertEquals((Integer) 30, scores.get(0));
	}
}
