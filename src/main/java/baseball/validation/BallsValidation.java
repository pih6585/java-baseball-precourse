package baseball.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BallsValidation {

	private static final String CHECK_BALL_RANGE_ERROR_MESSAGE = "볼은 1~9의 숫자만 가능 합니다.";
	private static final String CHECK_BALL_SIZE_ERROR_MESSAGE = "중복된 입력값이존재하거나 3자리의 입력값이 아닙니다.";
	private static final String EMPTY_MESSAGE = "";
	private static final String INT_REG_EXP = "(^[1-9]*$)";
	private static final int BALLS_SIZE = 3;

	private final boolean errorStatus;
	private final String message;

	private BallsValidation(boolean errorStatus, String message) {
		this.errorStatus = errorStatus;
		this.message = message;
	}

	public static BallsValidation checkBalls(String balls) {
		if (isNotMatchType(balls)) {
			return new BallsValidation(true, CHECK_BALL_RANGE_ERROR_MESSAGE);
		}
		if (isNotMatchBallsSize(balls)) {
			return new BallsValidation(true, CHECK_BALL_SIZE_ERROR_MESSAGE);
		}
		return new BallsValidation(false, EMPTY_MESSAGE);
	}

	private static boolean isNotMatchBallsSize(String balls) {
		return removeDuplicationSize(balls) != BALLS_SIZE;
	}

	private static int removeDuplicationSize(String customBalls) {
		Set<String> balls = new HashSet<>(Arrays.asList(customBalls.split("")));
		return balls.size();
	}

	private static boolean isNotMatchType(String balls) {
		return !balls.matches(INT_REG_EXP);
	}

	public boolean isProblem() {
		return errorStatus;
	}

	public String getErrorMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallsValidation that = (BallsValidation)o;
		return errorStatus == that.errorStatus && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorStatus, message);
	}
}
