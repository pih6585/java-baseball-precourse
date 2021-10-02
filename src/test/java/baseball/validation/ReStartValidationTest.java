package baseball.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReStartValidationTest {

	@Test
	@DisplayName("재시작에 대한 입력값 체크를 생성한다.")
	public void createValidation() {
		ReStartValidation reStartValidation = ReStartValidation.checkReStart("1");

		assertThat(reStartValidation).isEqualTo(ReStartValidation.checkReStart("1"));
	}

	@ParameterizedTest
	@DisplayName("재시작값이 1또는 2만 가능하다.")
	@CsvSource(value = {"1,false", "2,false", "3,true", "!,true", "q,true", "ㅂ,true"})
	public void checkNumber(String number, boolean isProblem) {
		ReStartValidation reStartValidation = ReStartValidation.checkReStart(number);

		assertThat(reStartValidation.isProblem()).isEqualTo(isProblem);
	}

}