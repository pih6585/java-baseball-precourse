package baseball.controller;

import baseball.generator.BallsGenerator;

import baseball.model.Balls;
import baseball.model.BaseBallGame;
import baseball.model.GameReStart;
import baseball.model.GameResult;

import baseball.validation.BallsValidation;
import baseball.validation.ReStartValidation;
import baseball.validation.Validate;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

	public void run() {
		boolean isGameEnd = gameStart(BallsGenerator.createTargetBalls());

		while (isReGame() && isGameEnd) {
			isGameEnd = gameStart(BallsGenerator.createTargetBalls());
		}

		OutputView.printEndGame();
	}

	private boolean gameStart(Balls targetBalls) {
		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);

		GameResult gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(inputCustomBalls()));

		while (baseBallGame.isContinue(gameResult)) {
			OutputView.printGameResult(gameResult);
			gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(inputCustomBalls()));
		}

		OutputView.printGameResult(gameResult);

		return !baseBallGame.isContinue(gameResult);
	}

	private String inputCustomBalls() {
		String balls = InputView.inputBalls();
		Validate ballsValidation = BallsValidation.checkBalls(balls);
		if (ballsValidation.isProblem()) {
			OutputView.printErrorMessage(ballsValidation.getErrorMessage());
			return inputCustomBalls();
		}
		return balls;
	}

	private boolean isReGame() {
		String choiceNumber = InputView.inputChoiceReGame();
		Validate reStartValidation = ReStartValidation.checkReStart(choiceNumber);
		if (reStartValidation.isProblem()) {
			OutputView.printErrorMessage(reStartValidation.getErrorMessage());
			return isReGame();
		}
		return new GameReStart(choiceNumber).isReGame();
	}

}
