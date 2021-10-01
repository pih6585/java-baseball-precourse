package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}