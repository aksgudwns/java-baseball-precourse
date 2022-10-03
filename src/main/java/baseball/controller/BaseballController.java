package baseball.controller;

import baseball.service.BaseballService;
import baseball.vo.BaseballGameAnswer;
import baseball.vo.BaseballGameResult;

public class BaseballController {

    BaseballService baseballService;

    public BaseballController() {
    }

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    /**
     *
     * 숫자야구 컴퓨터 정답 생성
     *
     */
    public BaseballGameAnswer createComputerAnswer() {
        return baseballService.createComputerAnswer();
    }

    /**
     *
     * 게임시작 문구를 출력한다.
     *
     */
    public void gameStart() {
        baseballService.gameStart();
    }

    /**
     *
     * 유저가 입력한 숫자야구 정답을 읽는다.
     *
     */
    public BaseballGameAnswer readUserAnswer() {
        String userInput = baseballService.readUserInput();
        return baseballService.getUserAnswer(userInput);
    }

    /**
     *
     * 유저가 입력한 숫자와 컴퓨터가 입력한 숫자를 비교한 뒤
     * 스트라이크 볼 개수를 계산하고, 출력한다.
     *
     */
    public BaseballGameResult getResult(BaseballGameAnswer computerAnswer, BaseballGameAnswer userAnswer) {
        return baseballService.getResult(computerAnswer, userAnswer);
    }

    /**
     *
     * 3스트라이크로 게임이 끝났는지 확인한다.
     * 게임이 끝난 경우 유저에게 1,2 둘 중 하나를 입력받아 1일 경우 게임을 새로 시작하고,
     * 2일 경우 프로그램을 종료한다.
     * 다른 입력값일 경우 IllegalArgumentException발생
     *
     */
    public boolean gameEnd(BaseballGameResult baseballGameResult) {
        return baseballService.gameEnd(baseballGameResult);
    }
}
