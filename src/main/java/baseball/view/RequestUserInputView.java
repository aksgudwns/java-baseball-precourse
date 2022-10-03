package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class RequestUserInputView extends BaseballGameView {
    public RequestUserInputView() {

    }

    @Override
    public void print() {
        super.print();
        System.out.print("숫자를 입력해 주세요 : ");
    }
}
