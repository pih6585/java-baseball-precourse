package baseball.generator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.Balls;

class BallsGeneratorTest {

	@Test
	@DisplayName("3자리 숫자를 입력받으면 BALLS 가 생성된다.")
	public void createInputBalls() {
		Balls balls = BallsGenerator.createCustomBalls("123");

		assertThat(balls).isEqualTo(BallsGenerator.createCustomBalls("123"));
	}

	@ParameterizedTest
	@DisplayName("입력받은 숫자가 3자리 숫자가 아니면 예외가 발생한다.")
	@CsvSource(value = "99,1000")
	public void checkInputBallsSize(String ballsNumber) {
		assertThrows(IllegalArgumentException.class,
			() -> BallsGenerator.createCustomBalls(ballsNumber));
	}

	@ParameterizedTest
	@DisplayName("입력받은 숫자가 문자열이 포함되면 예외가 발생된다.")
	@CsvSource(value = "!qa,z2e")
	public void checkInputBallsType(String ballsNumber) {
		assertThrows(IllegalArgumentException.class,
			() -> BallsGenerator.createCustomBalls(ballsNumber));
	}
}