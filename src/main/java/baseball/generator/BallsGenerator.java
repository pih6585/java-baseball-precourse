package baseball.generator;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Ball;
import baseball.model.Balls;
import nextstep.utils.Randoms;

public class BallsGenerator {

	private static final String CHECK_BALLS_SIZE_ERROR_MESSAGE = "야구게임의 볼은 3자리 입니다.";
	private static final int START_INCLUSIVE = 0;
	private static final int END_EXCLUSIVE = 3;
	private static final int BALLS_SIZE = 3;
	private static final int MIN_BALL_NUMBER = 1;
	private static final int MAX_BALL_NUMBER = 9;

	public static Balls createTargetBalls() {
		List<Ball> balls = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < END_EXCLUSIVE; i++) {
			balls.add(addBall(balls, i));
		}
		return new Balls(balls);
	}

	private static Ball addBall(List<Ball> balls, int position) {
		Ball ball = new Ball(Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER), position);
		if (balls.contains(ball)) {
			return addBall(balls, position);
		}
		return ball;
	}

	public static Balls createCustomBalls(String balls) {
		checkBallsSize(balls);
		return new Balls(toList(balls));
	}

	private static List<Ball> toList(String balls) {
		List<Ball> list = new ArrayList<>();
		for (int i = START_INCLUSIVE; i < balls.length(); i++) {
			list.add(new Ball(balls.charAt(i), i));
		}
		return list;
	}

	private static void checkBallsSize(String balls) {
		if (balls.length() != BALLS_SIZE) {
			throw new IllegalArgumentException(CHECK_BALLS_SIZE_ERROR_MESSAGE);
		}
	}
}
