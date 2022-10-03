package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BaseballGameMachine;

public class Application {

    private static BaseballController baseballController = new BaseballController();

    public static void main(String[] args) {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        initializeGame(baseballGameMachine);
    }

    private static void initializeGame(BaseballGameMachine baseballGameMachine) {
        //게임 초기화
        baseballGameMachine.initializeGame();
        startGame(baseballGameMachine);
    }

    private static void startGame(BaseballGameMachine baseballGameMachine) {
        //유저가 입력한 숫자 조회
        baseballController.readUserAnswer(baseballGameMachine);
        //게임결과조회
        baseballController.getResult(baseballGameMachine);
        //정답이 아닌경우 숫자를 다시 입력받음
        if(!baseballGameMachine.correctAnswer()) {
            startGame(baseballGameMachine);
            return;
        }
        //정답인 경우 처음부터 시작할지 끝낼지 유저의 판단에 따라 결정
        if(baseballGameMachine.correctAnswer() && !baseballController.isGameEnd())
            initializeGame(baseballGameMachine);
    }
}
