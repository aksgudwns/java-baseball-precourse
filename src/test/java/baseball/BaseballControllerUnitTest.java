package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.vo.ComputerAnswer;
import baseball.vo.UserAnswer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballControllerUnitTest extends NsTest {

    BaseballController baseballController;

    @BeforeEach
    void baseballController_초기화() {
        baseballController = new BaseballController(BaseballService.getInstance());
    }

    @Test
    void 컴퓨터생성숫자_체크() {
        ComputerAnswer computerAnswer = baseballController.createComputerAnswer();
        assertThat(computerAnswer.getNumber1()+'0' >= 49
                && computerAnswer.getNumber1()+'0' <= 57
                && computerAnswer.getNumber2()+'0' >= 49
                && computerAnswer.getNumber2()+'0' <= 57
                && computerAnswer.getNumber3()+'0' >= 49
                && computerAnswer.getNumber3()+'0' <= 57
        ).isTrue();
    }

    @Test
    void 컴퓨터생성숫자_범위체크() {
        ComputerAnswer computerAnswer = baseballController.createComputerAnswer();
        assertThat(computerAnswer.getNumber1() <= 9
                && computerAnswer.getNumber1() > 0
                && computerAnswer.getNumber2() <= 9
                && computerAnswer.getNumber2() > 0
                && computerAnswer.getNumber3() <= 9
                && computerAnswer.getNumber3() > 0
        ).isTrue();
    }

    @Test
    void 스트라이크_테스트() {
        assertThat(baseballController.getResult(new ComputerAnswer(1,2,3), new UserAnswer(1,4,5)).getStrike() == 1)
                .isTrue();
    }

    @Test
    void 볼_테스트() {
        assertThat(baseballController.getResult(new ComputerAnswer(1,2,3), new UserAnswer(2,4,5)).getBall() == 1)
                .isTrue();
    }

    @Test
    void 낫싱_테스트() {
        assertThat(baseballController.getResult(new ComputerAnswer(1,2,3), new UserAnswer(4,5,6)).getBall() == 0)
                .isTrue();
    }


    @Test
    void 예외_테스트_유저입력문자_길이3미만() {
        assertThatThrownBy(() -> BaseballService.getInstance().validateUserInput("33"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 예외_테스트_유저입력문자_숫자아닌경우() {
        assertThatThrownBy(() -> BaseballService.getInstance().validateUserInput("aa한글"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 예외_테스트_유저입력문자_중복숫자인경우() {
        assertThatThrownBy(() -> BaseballService.getInstance().validateUserInput("332"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 컴퓨터생성숫자_중복체크() {
        ComputerAnswer computerAnswer = baseballController.createComputerAnswer();
        assertThat(computerAnswer.getNumber1() != computerAnswer.getNumber2()
                && computerAnswer.getNumber2() != computerAnswer.getNumber3()
                && computerAnswer.getNumber3() != computerAnswer.getNumber1()).isTrue();
    }


    @Override
    protected void runMain() {

    }
}
