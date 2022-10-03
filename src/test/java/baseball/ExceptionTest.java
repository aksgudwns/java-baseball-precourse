package baseball;

import baseball.service.BaseballService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

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
}
