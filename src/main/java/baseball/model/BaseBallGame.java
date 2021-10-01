package baseball.model;

import java.util.Objects;

public class BaseBallGame {

	private Status status;
	private final Balls targetBalls;

	public BaseBallGame(Balls targetBalls) {
		this.targetBalls = targetBalls;
		status = Status.init();
	}

	public boolean isContinue() {
		return !status.isPerfectStrike();
	}

	public Status play(Balls customBalls) {
		status = Status.init();
		for (Ball ball : customBalls.getBalls()) {
			status = targetBalls.play(ball, status);
		}
		return status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseBallGame that = (BaseBallGame)o;
		return Objects.equals(status, that.status) && Objects.equals(targetBalls, that.targetBalls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, targetBalls);
	}
}
