package baseball.model;

import java.util.Objects;

public class Ball {
	private static final String CHECK_BALL_RANGE_ERROR_MESSAGE = "볼은 1~9의 숫자만 가능 합니다.";
	private static final int START_BALL_RANGE_NUMBER = 1;
	private static final int END_BALL_RANGE_NUMBER = 9;
	private static final int MIN_NUMBER_ASCII_CODE = 49;
	private static final int MAX_NUMBER_ASCII_CODE = 57;

	private final int ball;

	public Ball(int ball) {
		checkBallRange(ball);
		this.ball = ball;
	}

	public Ball(char ball) {
		checkBallRegular(ball);
		this.ball = toInt(ball);
	}

	private static void checkBallRegular(char ball) {
		if (ball < MIN_NUMBER_ASCII_CODE || ball > MAX_NUMBER_ASCII_CODE) {
			throw new IllegalArgumentException(CHECK_BALL_RANGE_ERROR_MESSAGE);
		}
	}

	private static int toInt(char ball) {
		return Character.getNumericValue(ball);
	}

	private void checkBallRange(int ball) {
		if (ball < START_BALL_RANGE_NUMBER || ball > END_BALL_RANGE_NUMBER) {
			throw new IllegalArgumentException(CHECK_BALL_RANGE_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball1 = (Ball)o;
		return ball == ball1.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ball);
	}

}

