package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("numbers 의 size 를 확인한다.")
	public void findNumbersSize() {
		int size = numbers.size();

		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("numbers 에 1,2,3의 문자열이 포함하는지 확인한다.")
	@CsvSource(value = "1,2,3")
	public void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("numbers 에 1,2,3의 문자열이 포함하는지 확인한다.")
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	public void checkContainsNumber(int number, boolean isContain) {
		assertThat(numbers.contains(number)).isEqualTo(isContain);
	}
}
