package baseball.view;

import javax.swing.text.View;

public class AskEndGame extends ViewReader {
    public AskEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
