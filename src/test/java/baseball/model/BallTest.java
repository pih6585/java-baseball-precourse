package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

	@Test
	@DisplayName("각각의 볼을 생성한다.")
	public void createBall() {
		Ball ball = new Ball(2, 0);

		assertThat(ball).isEqualTo(new Ball(2, 0));
	}

	@ParameterizedTest
	@DisplayName("볼은 1~9가 아니면 예외가 발생한다.")
	@CsvSource(value = {"0,0", "10,0"})
	public void checkBallRange(int ballNumber, int position) {
		assertThrows(IllegalArgumentException.class,
			() -> new Ball(ballNumber, position));
	}
}