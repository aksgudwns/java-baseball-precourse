package baseball.service;

import baseball.vo.BaseballGameResult;
import baseball.vo.ComputerAnswer;
import baseball.vo.UserAnswer;
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
     *
     * 숫자야구 컴퓨터 정답 생성
     * 중복인거 빼고 생성
     *
     */
    public ComputerAnswer createComputerAnswer() {
        boolean[] chk = new boolean[10];
        int number1 = Randoms.pickNumberInRange(1,9);
        chk[number1] = true;
        int number2 = getNoDuplicateNumber(chk);
        chk[number2] = true;
        int number3 = getNoDuplicateNumber(chk);
        return new ComputerAnswer(number1, number2, number3);
    }

    /**
     *
     * 중복숫자 체크 후 중복되지 않는 1~9사이의 숫자를 리턴한다.
     *
     */
    private int getNoDuplicateNumber(boolean[] chk) {
        int number = Randoms.pickNumberInRange(1,9);
        while(chk[number]) {
            number = Randoms.pickNumberInRange(1,9);
        }
        return number;
    }

    /**
     *
     * 게임시작 문구를 출력한다.
     *
     */
    public void gameStart() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /**
     *
     * 유저가 입력한 문자를 읽고, 유효성체크를 하여 올바른 입력값이 들어왔는지 확인한다.
     *
     */
    public String readUserInput() {
        String userInput = Console.readLine();
        validateUserInput(userInput);
        return userInput;
    }

    /**
     *
     * 입력한 문자의 유효성 체크를 한다.
     * 1. 길이가 세자리인지 확인
     * 2. 숫자인지 확인
     * 3. 중복문자가 있는지 확인
     *
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
     *
     * 입력된 charcter type의 문자가 0~9사이의 숫자인지 확인한다.
     *
     */
    public void numberCheck(char ch) {
        if(ch< 49 || ch> 57) throw new IllegalArgumentException();
    }

    /**
     *
     * 들어온 문자를 0~9사이 숫자로 전환한 후 중복숫자가 있는지 확인한다.
     *
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
     *
     * 유저에게서 입력받은 문자를 세개의 숫자로 변환 후 저장한다.
     *
     */
    public UserAnswer getUserAnswer(String userInput) {
        String[] strArray = userInput.split("");
        return new UserAnswer(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]), Integer.parseInt(strArray[2]));
    }

    /**
     *
     * 유저의 정답과 컴퓨터의 정답을 비교하여 볼, 스트라이크 개수를 계산한다.
     * 볼, 스트라이크 개수를 출력한다.
     *
     */
    public BaseballGameResult getResult(ComputerAnswer computerAnswer, UserAnswer userAnswer) {
        BaseballGameResult baseballGameResult =
                new BaseballGameResult(getBallNum(computerAnswer, userAnswer), getStrikeNum(computerAnswer, userAnswer));
        System.out.println(baseballGameResult.getResultMessage());
        return baseballGameResult;
    }

    /**
     *
     * 유저의 정답과 컴퓨터의 정답을 비교하여 볼의 개수를 계산한다.
     *
     */
    private int getBallNum(ComputerAnswer computerAnswer, UserAnswer userAnswer) {
        int ballNum = 0;
        if(computerAnswer.getNumber1() == userAnswer.getNumber2()
                || computerAnswer.getNumber1() == userAnswer.getNumber3())
            ballNum++;
        if(computerAnswer.getNumber2() == userAnswer.getNumber1()
                || computerAnswer.getNumber2() == userAnswer.getNumber3())
            ballNum++;
        if(computerAnswer.getNumber3() == userAnswer.getNumber1()
                || computerAnswer.getNumber3() == userAnswer.getNumber2())
            ballNum++;
        return ballNum;
    }

    /**
     *
     * 유저의 정답과 컴퓨터의 정답을 비교하여 스트라이크 개수를 계산한다.
     *
     */
    private int getStrikeNum(ComputerAnswer computerAnswer, UserAnswer userAnswer) {
        int strikeNum = 0;
        if(computerAnswer.getNumber1() == userAnswer.getNumber1())
            strikeNum++;
        if(computerAnswer.getNumber2() == userAnswer.getNumber2())
            strikeNum++;
        if(computerAnswer.getNumber3() == userAnswer.getNumber3())
            strikeNum++;
        return strikeNum;
    }

    /**
     *
     * 3스트라이크로 게임이 끝났는지 확인한다.
     * 게임이 끝난 경우 유저에게 1,2 둘 중 하나를 입력받아 1일 경우 게임을 새로 시작하고,
     * 2일 경우 프로그램을 종료한다.
     * 다른 입력값일 경우 IllegalArgumentException발생
     *
     */
    public boolean gameEnd(BaseballGameResult baseballGameResult) {
        if(baseballGameResult.getStrike() != 3)
            return false;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine().trim();
        if("1".equals(userInput)) return false;
        if("2".equals(userInput)) return true;
        throw new IllegalArgumentException();
    }
}
