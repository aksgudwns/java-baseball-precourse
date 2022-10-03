package baseball.domain;

public class BaseballGameResult {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public BaseballGameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

}
