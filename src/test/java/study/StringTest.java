package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("1,2를 ,로 split 했을때 분리되는지 확인한다.")
	public void confirmSplitByString() {
		String token = "1,2";
		String[] tokens = token.split(",");

		assertThat(tokens).contains("1", "2");
	}

	@Test
	@DisplayName("1 을 ,로 split 했을때 1만을 포함하는 배열이 반환한다.")
	public void returnSplitByArray() {
		String token = "1";
		String[] tokens = token.split(",");

		assertThat(tokens).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2)의 값이 주어졌을때 String 의 substring 메소드를 활용해 ()를제거하고 1,2를 반환한다.")
	public void toSubString() {
		String token = "(1,2)";
		token = token.substring(1, 4);

		assertThat(token).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열 abc의 특정 위치 값을 가져 온다.")
	public void testCharAt() {
		String token = "abc";
		char character = token.charAt(0);

		assertThat(character).isEqualTo('a');
	}

	@Test
	@DisplayName("문자열 abc 의 특정 위치 범위가 넘어가면 예외가 발생한다.")
	public void checkTokenIndexRange() {
		String token = "abc";

		assertThatThrownBy(() -> token.charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
