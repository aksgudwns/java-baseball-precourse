package baseball.service;

import baseball.vo.ComputerAnswer;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    static BaseballService instance;

    public static BaseballService getInstance() {
        if(instance == null) {
            instance = new BaseballService();
        }
        return instance;
    }

    /*
     * 숫자야구 컴퓨터 정답 생성
     * */
    public ComputerAnswer createComputerAnswer() {
        return new ComputerAnswer(Randoms.pickNumberInRange(1,9), Randoms.pickNumberInRange(1,9), Randoms.pickNumberInRange(1,9));
    }

    /*
     * 게임시작 문구를 출력한다.
     * */
    public void gameStart() {
        System.out.print("숫자를 입력해 주세요 : ");
    }


}
