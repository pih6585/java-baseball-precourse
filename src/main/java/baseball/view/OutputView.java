package baseball.view;

import baseball.model.Status;

public class OutputView {

	private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String EMPTY_MESSAGE = "";
	private static final String RE_END_GAME_MESSAGE = "게임이 종료 되었습니다.";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String BALL_MESSAGE = "볼";

	public static void printGameResult(Status status) {
		if (!status.isNothing()) {
			printGameReview(status);
		}
		if (status.isNothing()) {
			System.out.println(NOTHING_MESSAGE);
		}
		if (status.isPerfectStrike()) {
			System.out.println(END_GAME_MESSAGE);
		}
	}

	private static void printGameReview(Status status) {
		String strikeMessage = EMPTY_MESSAGE;
		String ballMessage = EMPTY_MESSAGE;
		if (status.existStrike()) {
			strikeMessage = status.getStrike() + STRIKE_MESSAGE;

		}
		if (status.existBall()) {
			ballMessage = status.getBall() + BALL_MESSAGE;
		}
		System.out.println(strikeMessage + " " + ballMessage);
	}

	public static void printEndGame() {
		System.out.println(RE_END_GAME_MESSAGE);
	}
}
