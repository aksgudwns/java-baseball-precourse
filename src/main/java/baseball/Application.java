package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BaseballGame;

public class Application {

    private static BaseballController baseballController = new BaseballController();

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        initializeGame(baseballGame);
    }

    private static void initializeGame(BaseballGame baseballGame) {
        //게임 초기화
        baseballGame.initializeGame();
        startGame(baseballGame);
    }

    private static void startGame(BaseballGame baseballGame) {
        //게임진행
        baseballController.startGame(baseballGame, baseballController.getUserAnswer(baseballGame));
        //정답이 아닌경우 숫자를 다시 입력받음
        if(!baseballGame.isCorrectAnswer()) {
            startGame(baseballGame);
            return;
        }
        //정답인 경우 처음부터 시작할지 끝낼지 유저의 판단에 따라 결정
        if(baseballGame.isCorrectAnswer() && !baseballController.isGameEnd())
            initializeGame(baseballGame);
    }
}
