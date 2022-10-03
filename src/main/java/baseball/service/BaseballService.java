package baseball.service;

import baseball.domain.BaseballGameAnswer;
import baseball.domain.BaseballGameMachine;
import baseball.domain.BaseballGameResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    static BaseballService instance;

    public static BaseballService getInstance() {
        if(instance == null) {
            instance = new BaseballService();
        }
        return instance;
    }


    /**
     * 유저가 입력한 문자를 읽고, 유효성체크를 하여 올바른 입력값이 들어왔는지 확인한다.
     */
    public void readUserAnswer(BaseballGameMachine baseballGameMachine, String userInput) {
        validateUserInput(userInput);
        char[] userInputs = userInput.toCharArray();
        baseballGameMachine.setUserAnswer(new int[] {userInputs[0]-'0', userInputs[1]-'0', userInputs[2]-'0'});
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
        if(ch< 49 || ch> 57) throw new IllegalArgumentException();
    }

    /**
     * 들어온 문자를 0~9사이 숫자로 전환한 후 중복숫자가 있는지 확인한다.
     */
    public boolean duplicateCheck(String userInput) {
        boolean[] numbers = new boolean[10];
        for(String str : userInput.split("")) {
            if(numbers[Integer.parseInt(str)]) throw new IllegalArgumentException();

            numbers[Integer.parseInt(str)] = true;
        }
        return false;
    }


    /**
     * 숫자야구 결과를 조회한다.
     */
    public BaseballGameResult getResult(BaseballGameMachine baseballGameMachine) {
        return baseballGameMachine.getResult();
    }

    /**
     * 3스트라이크로 게임이 끝났는지 확인한다.
     * 게임이 끝난 경우 유저에게 1,2 둘 중 하나를 입력받아 1일 경우 게임을 새로 시작하고,
     * 2일 경우 프로그램을 종료한다.
     * 다른 입력값일 경우 IllegalArgumentException발생
     */
    public boolean gameEnd(String userInput) {
        if("1".equals(userInput)) return false;
        if("2".equals(userInput)) return true;
        throw new IllegalArgumentException();
    }

}
