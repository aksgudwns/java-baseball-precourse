package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.service.BaseballService;
import baseball.domain.BaseballGameResult;
import baseball.view.AskEndGameView;
import baseball.view.BaseballGameResultView;
import baseball.view.RequestUserInputView;

public class BaseballController {

    private static BaseballService baseballService = new BaseballService();

    public BaseballController() {
    }

    /**
     * 유저가 입력한 숫자야구 정답을 읽는다.
     */
    public String getUserAnswer(BaseballGame baseballGame) {
        RequestUserInputView requestUserInputView = new RequestUserInputView();
        requestUserInputView.print();
        return baseballService.getUserAnswer(baseballGame, requestUserInputView.readUserInput());
    }

    /**
     * 유저가 입력한 숫자와 컴퓨터가 입력한 숫자를 비교한 뒤
     * 스트라이크 볼 개수를 계산하고, 출력한다.
     */
    public void startGame(BaseballGame baseballGame, String userInput) {
        baseballService.setBaseballGameResult(baseballGame, userInput);
        BaseballGameResultView baseballGameResultView =
                new BaseballGameResultView(baseballService.getBaseballGameResult(baseballGame));
        baseballGameResultView.print();
    }

    /**
     * 3스트라이크로 게임이 끝났는지 확인한다.
     * 게임이 끝난 경우 유저에게 1,2 둘 중 하나를 입력받아 1일 경우 게임을 새로 시작하고,
     * 2일 경우 프로그램을 종료한다.
     * 다른 입력값일 경우 IllegalArgumentException발생
     */
    public boolean isGameEnd() {
        AskEndGameView askEndGameView = new AskEndGameView();
        askEndGameView.print();
        return baseballService.isGameEnd(askEndGameView.readUserInput());
    }
}
