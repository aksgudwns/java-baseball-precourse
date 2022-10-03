package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameMachine {

    private BaseballGameAnswer computerAnswer;
    private BaseballGameAnswer userAnswer;

    public BaseballGameMachine() {
        createGameAnswer();
    }

    /**
     * 컴퓨터의 야구놀이 숫자를 생성한다.
     */
    private void createGameAnswer() {
        boolean[] duplicateCheck = new boolean[10];
        int number1 = Randoms.pickNumberInRange(1,9);
        duplicateCheck[number1] = true;
        int number2 = getNoDuplicateNumber(duplicateCheck);
        duplicateCheck[number2] = true;
        int number3 = getNoDuplicateNumber(duplicateCheck);
        this.computerAnswer = new BaseballGameAnswer(number1, number2, number3);
    }


    /**
     * 중복숫자 체크 후 중복되지 않는 1~9사이의 숫자를 리턴한다.
     */
    private int getNoDuplicateNumber(boolean[] duplicateCheck) {
        int number = Randoms.pickNumberInRange(1,9);
        while(duplicateCheck[number]) {
            number = Randoms.pickNumberInRange(1,9);
        }
        return number;
    }

    public void setUserAnswer(int[] userAnswer) {
        this.userAnswer = new BaseballGameAnswer(userAnswer[0], userAnswer[1], userAnswer[2]);
    }

    public BaseballGameResult getResult() {
        BaseballGameResult baseballGameResult =
                new BaseballGameResult(getBallNum(computerAnswer, userAnswer), getStrikeNum(computerAnswer, userAnswer));
        return baseballGameResult;
    }

    /**
     * 유저의 정답과 컴퓨터의 정답을 비교하여 볼의 개수를 계산한다.
     */
    private int getBallNum(BaseballGameAnswer computerAnswer, BaseballGameAnswer userAnswer) {
        int ballCount = 0;
        if(computerAnswer.getNumber1() == userAnswer.getNumber2()
                || computerAnswer.getNumber1() == userAnswer.getNumber3())
            ballCount++;
        if(computerAnswer.getNumber2() == userAnswer.getNumber1()
                || computerAnswer.getNumber2() == userAnswer.getNumber3())
            ballCount++;
        if(computerAnswer.getNumber3() == userAnswer.getNumber1()
                || computerAnswer.getNumber3() == userAnswer.getNumber2())
            ballCount++;
        return ballCount;
    }

    /**
     * 유저의 정답과 컴퓨터의 정답을 비교하여 스트라이크 개수를 계산한다.
     */
    private int getStrikeNum(BaseballGameAnswer computerAnswer, BaseballGameAnswer userAnswer) {
        int strikeCount = 0;
        if(computerAnswer.getNumber1() == userAnswer.getNumber1())
            strikeCount++;
        if(computerAnswer.getNumber2() == userAnswer.getNumber2())
            strikeCount++;
        if(computerAnswer.getNumber3() == userAnswer.getNumber3())
            strikeCount++;
        return strikeCount;
    }

}
