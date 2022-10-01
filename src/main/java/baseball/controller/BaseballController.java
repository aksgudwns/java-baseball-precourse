package baseball.controller;

import baseball.service.BaseballService;
import baseball.vo.BaseballGameResult;
import baseball.vo.ComputerAnswer;
import baseball.vo.UserAnswer;

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
    public ComputerAnswer createComputerAnswer() {
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
    public UserAnswer readUserAnswer() {
        String userInput = baseballService.readUserInput();
        return baseballService.getUserAnswer(userInput);
    }

    public BaseballGameResult getResult(ComputerAnswer computerAnswer, UserAnswer userAnswer) {
        return null;
    }

    public boolean gameEnd(BaseballGameResult baseballGameResult) {
        return false;
    }
}
