package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusTest {

	@Test
	@DisplayName("게임의 상황을 초기화 한다.")
	public void initStatus() {
		Status status = Status.init();

		assertThat(status).isEqualTo(Status.init());
	}

	@Test
	@DisplayName("스트라이크이면 스트라이크 점수가 1점씩 올라간다.")
	public void strike() {
		Status status = Status.init();
		status = status.strike();
		assertThat(status.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("볼이면 볼의 점수가 1점씩 올라간다.")
	public void ball() {
		Status status = Status.init();
		status = status.ball();
		assertThat(status.getBall()).isEqualTo(1);
	}

	@Test
	@DisplayName("스트라이크와 볼이 0 이면 낫싱이다.")
	public void isNothing() {
		Status status = Status.init();
		assertThat(status.isNothing()).isTrue();
	}

	@Test
	@DisplayName("스트라이크가 3개이면 퍼펙트 이다.")
	public void isPerfectStrike() {
		Status status = Status.init();
		status = status.strike();
		status = status.strike();
		status = status.strike();
		assertThat(status.isPerfectStrike()).isTrue();
	}

	@Test
	@DisplayName("스트라이크가 1개라도 있으면 스트라이크가 존재한다.")
	public void existStrike() {
		Status status = Status.init();
		status = status.strike();
		assertThat(status.existStrike()).isTrue();
	}

	@Test
	@DisplayName("볼이 1개라도 있으면 볼이 존재한다.")
	public void existBall() {
		Status status = Status.init();
		status = status.ball();
		assertThat(status.existBall()).isTrue();
	}
}