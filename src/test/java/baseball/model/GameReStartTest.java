package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameReStartTest {

	@Test
	@DisplayName("게임의 재신청 유무를 생성한다.")
	public void createGameReStart() {
		GameReStart gameReStart = new GameReStart("1");

		assertThat(gameReStart).isEqualTo(new GameReStart("1"));
	}

	@ParameterizedTest
	@DisplayName("게임의 재신청 번호가 1 또는 2가 아니면 예외가 발생한다.")
	@CsvSource(value = "0,3")
	public void checkRangeNumber(String choiceNumber) {
		assertThrows(IllegalArgumentException.class,
			() -> new GameReStart(choiceNumber));
	}

	@Test
	@DisplayName("게임의 재신청 번호가 1이면 게임을 재시작한다.")
	public void isReGameByTrue() {
		GameReStart gameReStart = new GameReStart("1");

		assertThat(gameReStart.isReGame()).isTrue();
	}

	@Test
	@DisplayName("게임의 재신청 번호가 2이면 게임을 종료한다..")
	public void isReGameByFalse() {
		GameReStart gameReStart = new GameReStart("2");

		assertThat(gameReStart.isReGame()).isFalse();
	}
}