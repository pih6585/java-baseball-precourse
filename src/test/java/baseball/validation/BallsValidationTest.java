package baseball.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallsValidationTest {

	@Test
	@DisplayName("balls의 입력값에 대한 체크를 생성한다.")
	public void createValidation() {
		BallsValidation ballsValidation = BallsValidation.checkBalls("123");

		assertThat(ballsValidation).isEqualTo(BallsValidation.checkBalls("123"));
	}

	@ParameterizedTest
	@DisplayName("볼은 0을 포함하지 않고 중복되지않은 3자리 수를 가지고있다.")
	@CsvSource(value = {"123,false", "748,false", "012,true", "!qㄱ,true", "1234,true", "12,true"})
	public void checkNumber(String balls, boolean isProblem) {
		BallsValidation ballsValidation = BallsValidation.checkBalls(balls);

		assertThat(ballsValidation.isProblem()).isEqualTo(isProblem);
	}
}