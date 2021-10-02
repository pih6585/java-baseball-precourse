package baseball.model;

import java.util.Objects;

public class Ball {
	private static final String CHECK_BALL_RANGE_ERROR_MESSAGE = "볼은 1~9의 숫자만 가능 합니다.";
	private static final int START_BALL_RANGE_NUMBER = 1;
	private static final int END_BALL_RANGE_NUMBER = 9;

	private final int ball;
	private final int position;

	public Ball(int ball, int position) {
		checkBallRange(ball);
		this.ball = ball;
		this.position = position;
	}

	public Ball(String ball, int position) {
		this.ball = toInt(ball);
		this.position = position;
	}

	private static int toInt(String ball) {
		return Integer.parseInt(ball);
	}

	private void checkBallRange(int ball) {
		if (ball < START_BALL_RANGE_NUMBER || ball > END_BALL_RANGE_NUMBER) {
			throw new IllegalArgumentException(CHECK_BALL_RANGE_ERROR_MESSAGE);
		}
	}

	public Status play(Ball customBall) {
		if (this.equals(customBall)) {
			return Status.STRIKE;
		}
		if (isSameNumber(customBall)) {
			return Status.BALL;
		}
		return Status.NOTHING;
	}

	public boolean isSameNumber(Ball ball) {
		return this.ball == ball.ball;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball1 = (Ball)o;
		return ball == ball1.ball && position == ball1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ball, position);
	}

}

