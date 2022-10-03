package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class BaseballGameView {
    public void print() {

    }

    public String readUserInput() {
        return Console.readLine();
    }
}
