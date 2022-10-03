package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BaseballGameMachine;
import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(BaseballService.getInstance());
        initializeGame(baseballController);
    }

    private static void initializeGame(BaseballController baseballController) {
        //컴퓨터 숫자 생성
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        startGame(baseballController, baseballGameMachine);
    }

    private static void startGame(BaseballController baseballController, BaseballGameMachine baseballGameMachine) {
        //유저가 입력한 숫자 조회
        baseballController.readUserAnswer(baseballGameMachine);
        //게임결과조회
        baseballController.getResult(baseballGameMachine);
        //3스트라이크가 아닌경우 다시 시작
        if(baseballGameMachine.getResult().getStrike() != 3) {
            startGame(baseballController, baseballGameMachine);
            return;
        }
        //3스트라이크인 경우 처음부터 시작할지 끝낼지 유저의 판단에 따라 결정
        if(baseballGameMachine.getResult().getStrike() == 3 && !baseballController.gameEnd())
            initializeGame(baseballController);
    }
}
