package baseball.model;

import java.util.Objects;

public class GameReStart {

	private static final String CHOICE_NUMBER_RANGE_ERROR_MESSAGE = "선택 숫자는 1또는 2만 가능합니다.";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final int END_NUMBER = 2;
	private static final int RE_START_NUMBER = 1;

	private final int choiceNumber;

	public GameReStart(String choiceNumber) {
		checkMatchTypeNumber(choiceNumber);
		this.choiceNumber = toInt(choiceNumber);
	}

	private void checkMatchTypeNumber(String choiceNumber) {
		if (!choiceNumber.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(CHOICE_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	private int toInt(String choiceNumber) {
		int number = Integer.parseInt(choiceNumber);
		checkRangeNumber(number);
		return number;
	}

	public boolean isReGame() {
		return choiceNumber == RE_START_NUMBER;
	}

	private void checkRangeNumber(int choiceNumber) {
		if (choiceNumber < RE_START_NUMBER || choiceNumber > END_NUMBER) {
			throw new IllegalArgumentException(CHOICE_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameReStart that = (GameReStart)o;
		return choiceNumber == that.choiceNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(choiceNumber);
	}
}
