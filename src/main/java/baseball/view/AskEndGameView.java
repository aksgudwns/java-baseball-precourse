package baseball.view;

public class AskEndGameView extends BaseballGameView {
    public AskEndGameView() {

    }

    @Override
    public void print() {
        super.print();
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}