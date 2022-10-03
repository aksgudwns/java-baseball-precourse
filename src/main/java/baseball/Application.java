package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.vo.BaseballGameAnswer;
import baseball.vo.BaseballGameResult;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(BaseballService.getInstance());
        initGame(baseballController);
    }

    private static void initGame(BaseballController baseballController) {
        //컴퓨터 숫자 생성
        BaseballGameAnswer computerAnswer = baseballController.createComputerAnswer();
        startGame(baseballController, computerAnswer);
    }

    private static void startGame(BaseballController baseballController, BaseballGameAnswer computerAnswer) {
        //게임시작
        baseballController.gameStart();
        //유저가 입력한 숫자 조회
        BaseballGameAnswer userAnswer = baseballController.readUserAnswer();
        //게임결과조회
        BaseballGameResult baseballGameResult = baseballController.getResult(computerAnswer, userAnswer);
        //3스트라이크가 아닌경우 다시 시작
        if(baseballGameResult.getStrike() != 3)
            startGame(baseballController, computerAnswer);
        //3스트라이크인 경우 처음부터 시작할지 끝낼지 유저의 판단에 따라 결정
        if(baseballGameResult.getStrike() == 3 && !baseballController.gameEnd(baseballGameResult))
            initGame(baseballController);
    }
}
