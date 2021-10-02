package baseball.model;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class GameResult {

	private static final int PERFECT_CONDITION = 3;

	private final Map<Status, Integer> result;

	public GameResult(Map<Status, Integer> result) {
		this.result = Collections.unmodifiableMap(result);
	}

	public boolean isNothing() {
		return result.get(Status.NOTHING) == PERFECT_CONDITION;
	}

	public boolean isContinueGame() {
		return result.get(Status.STRIKE) != PERFECT_CONDITION;
	}

	public int countStrike() {
		return result.get(Status.STRIKE);
	}

	public int countBall() {
		return result.get(Status.BALL);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return Objects.equals(result, that.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(result);
	}
}
