package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.generator.BallsGenerator;

class BallsTest {

	@Test
	@DisplayName("3자리의 볼을 생성한다.")
	public void createBalls() {
		Balls balls = new Balls(Arrays.asList(new Ball(1, 0), new Ball(2, 0), new Ball(3, 0)));

		assertThat(balls).isEqualTo(new Balls(Arrays.asList(new Ball(1, 0), new Ball(2, 0), new Ball(3, 0))));
	}

	@Test
	@DisplayName("볼은 3자리가 아니면 예외가 발생한다.")
	public void checkBallsSize() {
		assertThrows(IllegalArgumentException.class,
			() -> new Balls(Arrays.asList(new Ball(1, 0), new Ball(2, 0))));
	}

	@Test
	@DisplayName("볼의 숫자가 중복되면 예외가 발생한다.")
	public void checkDuplication() {
		assertThrows(IllegalArgumentException.class,
			() -> new Balls(Arrays.asList(new Ball(1, 0), new Ball(1, 0), new Ball(1, 0))));
	}

	@Test
	@DisplayName("볼과 볼의 자리수와 값이 일치하면 스트라이크이다.")
	public void playStrike() {
		Balls targetBalls = BallsGenerator.createCustomBalls("123");
		Balls customBalls = BallsGenerator.createCustomBalls("145");
		Status status = Status.init();
		Status result = targetBalls.play(customBalls.getBalls().get(0), 0, status);

		assertThat(result.getStrike()).isEqualTo(1);

	}

	@Test
	@DisplayName("볼과 볼의 값이 일치하고 위치가 다르면 볼이다.")
	public void playBall() {
		Balls targetBalls = BallsGenerator.createCustomBalls("123");
		Balls customBalls = BallsGenerator.createCustomBalls("415");
		Status status = Status.init();
		Status result = targetBalls.play(customBalls.getBalls().get(1), 1, status);

		assertThat(result.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("볼과 볼의 값와 위치가 다르면 nothing 이다.")
	public void playNothing() {
		Balls targetBalls = BallsGenerator.createCustomBalls("123");
		Balls customBalls = BallsGenerator.createCustomBalls("465");
		Status status = Status.init();
		Status result = targetBalls.play(customBalls.getBalls().get(0), 0, status);

		assertThat(result).isEqualTo(Status.init());
	}
}