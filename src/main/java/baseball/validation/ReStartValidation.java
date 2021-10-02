package baseball.validation;

import java.util.Objects;

public class ReStartValidation {

	private static final String CHOICE_NUMBER_RANGE_ERROR_MESSAGE = "선택 숫자는 1또는 2만 가능합니다.";
	private static final String INT_REG_EXP = "[12]";
	private static final String EMPTY_MESSAGE = "";

	private final boolean error;
	private final String message;

	private ReStartValidation(boolean error, String message) {
		this.error = error;
		this.message = message;
	}

	public static ReStartValidation checkReStart(String checkNumber) {
		if (isNotMatchType(checkNumber)) {
			return new ReStartValidation(true, CHOICE_NUMBER_RANGE_ERROR_MESSAGE);
		}
		return new ReStartValidation(false, EMPTY_MESSAGE);
	}

	private static boolean isNotMatchType(String checkNumber) {
		return !checkNumber.matches(INT_REG_EXP);
	}

	public boolean isProblem() {
		return error;
	}

	public String getErrorMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ReStartValidation that = (ReStartValidation)o;
		return error == that.error && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(error, message);
	}
}
