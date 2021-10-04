package baseball.generator;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Ball;
import baseball.model.Balls;
import nextstep.utils.Randoms;

public class BallsGenerator {

	private static final String CHECK_BALLS_SIZE_ERROR_MESSAGE = "야구게임의 볼은 3자리 입니다.";
	private static final String CHECK_MATCH_TYPE_ERROR_MESSAGE = "숫자만 입력 가능 합니다.";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final String REGEX = "";
	private static final int START_INCLUSIVE = 0;
	private static final int BALLS_SIZE = 3;
	private static final int MIN_BALL_NUMBER = 1;
	private static final int MAX_BALL_NUMBER = 9;

	public static Balls createTargetBalls() {
		List<Integer> balls = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < BALLS_SIZE; i++) {
			balls.add(addBall(balls));
		}
		return createBalls(balls);
	}

	private static Balls createBalls(List<Integer> balls) {
		List<Ball> targetBalls = new ArrayList<>();
		for (int index = 0; index < balls.size(); index++) {
			targetBalls.add(new Ball(balls.get(index), index));
		}
		return new Balls(targetBalls);
	}

	private static int addBall(List<Integer> balls) {
		int ball = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
		if (balls.contains(ball)) {
			return addBall(balls);
		}
		return ball;
	}

	public static Balls createCustomBalls(String balls) {
		checkBallsSize(balls);
		checkMatchTypeNumber(balls);
		return new Balls(toList(balls));
	}

	private static List<Ball> toList(String balls) {
		List<Ball> customBalls = new ArrayList<>();
		String[] tokens = toSplit(balls);
		for (int index = START_INCLUSIVE; index < tokens.length; index++) {
			customBalls.add(new Ball(tokens[index], index));
		}
		return customBalls;
	}

	private static String[] toSplit(String balls) {
		return balls.split(REGEX);
	}

	private static void checkMatchTypeNumber(String balls) {
		if (!balls.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(CHECK_MATCH_TYPE_ERROR_MESSAGE);
		}
	}

	private static void checkBallsSize(String balls) {
		if (balls.length() != BALLS_SIZE) {
			throw new IllegalArgumentException(CHECK_BALLS_SIZE_ERROR_MESSAGE);
		}
	}
}
