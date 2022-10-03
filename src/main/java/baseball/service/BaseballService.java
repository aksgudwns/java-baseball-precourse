package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameResult;
import baseball.domain.BaseballGameRule;

import java.util.HashSet;
import java.util.Set;

public class BaseballService {

    private static final char CHAR_1 = 49;
    private static final char CHAR_9 = 57;

    /**
     * 유저가 입력한 문자를 읽고, 유효성체크를 하여 올바른 입력값이 들어왔는지 확인한다.
     */
    public String getUserAnswer(BaseballGame baseballGame, String userInput) {
        validateUserInput(userInput);
        return userInput;
    }

    /**
     * 입력한 문자의 유효성 체크를 한다.
     * 1. 길이가 세자리인지 확인
     * 2. 숫자인지 확인
     * 3. 중복문자가 있는지 확인
     */
    public void validateUserInput(String userInput) {
        //길이가 3인지 확인
        if(userInput == null || userInput.length() != 3) throw new IllegalArgumentException();

        //숫자인지 확인
        for(char ch : userInput.toCharArray()) {
            numberCheck(ch);
        }

        //중복숫자가 있는지 체크
        duplicateCheck(userInput);
    }

    /**
     * 입력된 charcter type의 문자가 0~9사이의 숫자인지 확인한다.
     */
    public void numberCheck(char ch) {
        if(ch< CHAR_1 || ch> CHAR_9) throw new IllegalArgumentException();
    }

    /**
     * 들어온 문자를 0~9사이 숫자로 전환한 후 중복숫자가 있는지 확인한다.
     */
    public void duplicateCheck(String userInput) {
        Set duplicateCheckSet = new HashSet<Integer>();
        for(String str : userInput.split("")) {
            duplicateCheckSet.add(Integer.parseInt(str));
        }
        if(duplicateCheckSet.size() != userInput.length())
            throw new IllegalArgumentException();
    }


    /**
     * 숫자야구 결과를 조회한다.
     */
    public void setBaseballGameResult(BaseballGame baseballGame, String userInput) {
        baseballGame.setResult(userInput);
    }

    /**
     * 3스트라이크로 게임이 끝났는지 확인한다.
     * 게임이 끝난 경우 유저에게 1,2 둘 중 하나를 입력받아 1일 경우 게임을 새로 시작하고,
     * 2일 경우 프로그램을 종료한다.
     * 다른 입력값일 경우 IllegalArgumentException발생
     */
    public boolean isGameEnd(String userInput) {
        if(BaseballGameRule.REPLAY.getUserInput().equals(userInput)) return false;
        if(BaseballGameRule.END.getUserInput().equals(userInput)) return true;
        throw new IllegalArgumentException();
    }

    public BaseballGameResult getBaseballGameResult(BaseballGame baseballGame) {
        return baseballGame.getResult();
    }
}
