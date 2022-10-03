package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {

    private BaseballGameAnswer computerAnswer;
    private BaseballGameResult baseballGameResult;

    private static final int GAME_MIN_RANGE = 1;
    private static final int GAME_MAX_RANGE = 9;

    private static final int GAME_END_STRIKE_NUMBER = 3;

    public BaseballGame() {

    }

    /**
     * 컴퓨터의 야구놀이 숫자를 생성한다.
     */
    public void initializeGame() {
        Set<Integer> duplicateCheckSet = new HashSet<>();
        int number1 = Randoms.pickNumberInRange(GAME_MIN_RANGE,GAME_MAX_RANGE);
        duplicateCheckSet.add(number1);
        int number2 = getNoDuplicateNumber(duplicateCheckSet);
        duplicateCheckSet.add(number2);
        int number3 = getNoDuplicateNumber(duplicateCheckSet);
        this.computerAnswer = new BaseballGameAnswer(number1, number2, number3);
    }


    /**
     * 중복숫자 체크 후 중복되지 않는 게임 최소 숫자 ~ 게임 최대 숫자 사이의 숫자를 리턴한다.
     */
    private int getNoDuplicateNumber(Set<Integer> duplicateCheck) {
        int number = Randoms.pickNumberInRange(GAME_MIN_RANGE, GAME_MAX_RANGE);
        while(duplicateCheck.contains(number)) {
            number = Randoms.pickNumberInRange(GAME_MIN_RANGE, GAME_MAX_RANGE);
        }
        return number;
    }

    public BaseballGameAnswer getUserAnswer(String userInput) {
        String[] userInputs = userInput.split("");
        return new BaseballGameAnswer(Integer.parseInt(userInputs[0]),
                Integer.parseInt(userInputs[1]),
                Integer.parseInt(userInputs[2]));
    }

    public void setResult(String userInput) {
        BaseballGameAnswer userAnswer = getUserAnswer(userInput);
        this.baseballGameResult = new BaseballGameResult(
                getBallNum(computerAnswer, userAnswer), getStrikeNum(computerAnswer, userAnswer));
    }

    public BaseballGameResult getResult() {
        return this.baseballGameResult;
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

    public boolean isCorrectAnswer() {
        return this.baseballGameResult.getStrike() == GAME_END_STRIKE_NUMBER;
    }

}
