package baseball.view;

import nextstep.utils.Console;

public class InputView {

	private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요.";
	private static final String INPUT_CHOICE_RE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String inputBalls() {
		System.out.println(INPUT_BALLS_MESSAGE);
		return Console.readLine();
	}

	public static String inputChoiceReGame() {
		System.out.println(INPUT_CHOICE_RE_GAME_MESSAGE);
		return Console.readLine();
	}

}
