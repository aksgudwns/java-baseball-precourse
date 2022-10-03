package baseball.view;

import baseball.domain.BaseballGameResult;

public class BaseballGameResultView extends BaseballGameView {

    BaseballGameResult baseballGameResult;

    public BaseballGameResultView() {

    }

    public BaseballGameResultView(BaseballGameResult baseballGameResult) {
        this.baseballGameResult = baseballGameResult;
    }

    @Override
    public void print() {
        super.print();
        int ball = baseballGameResult.getBall();
        int strike = baseballGameResult.getStrike();

        String message = ball + "볼 " + strike + "스트라이크";
        if(ball == 0 && strike == 0)
            message = "낫싱";
        if(ball == 0 && strike != 0)
            message = strike + "스트라이크";
        if(ball != 0 && strike == 0)
            message = ball + "볼";

        System.out.println(message);
    }
}
