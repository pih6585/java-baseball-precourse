package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusTest {

	@Test
	@DisplayName("status는 strike, ball, nothing을 포함하고있다.")
	public void containsValues() {
		assertThat(Status.getValues()).contains(Status.STRIKE, Status.BALL, Status.NOTHING);
	}
}