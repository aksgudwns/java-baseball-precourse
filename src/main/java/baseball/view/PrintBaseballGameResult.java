package baseball.view;

import baseball.domain.BaseballGameResult;

public class PrintBaseballGameResult {
    public PrintBaseballGameResult(BaseballGameResult baseballGameResult) {
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
