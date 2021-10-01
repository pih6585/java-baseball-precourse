package baseball.controller;

import baseball.generator.BallsGenerator;

import baseball.model.Balls;
import baseball.model.BaseBallGame;
import baseball.model.GameReStart;
import baseball.model.GameResult;

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

		GameResult gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(InputView.inputBalls()));

		while (baseBallGame.isContinue(gameResult)) {
			OutputView.printGameResult(gameResult);
			gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(InputView.inputBalls()));
		}

		OutputView.printGameResult(gameResult);

		return !baseBallGame.isContinue(gameResult);
	}

	private boolean isReGame() {
		return new GameReStart(InputView.inputChoiceReGame()).isReGame();
	}

}
