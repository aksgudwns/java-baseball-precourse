package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class ViewReader {
    public String readUserInput() {
        return Console.readLine();
    }
}
