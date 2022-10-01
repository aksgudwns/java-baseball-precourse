package baseball.vo;

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

    public String getResultMessage() {
        if(ball == 0 && strike == 0)
            return "낫싱";
        if(ball == 0 && strike != 0)
            return strike + "스트라이크";
        if(ball != 0 && strike == 0)
            return ball + "볼";
        return ball + "볼 " + strike + "스트라이크";
    }
}
