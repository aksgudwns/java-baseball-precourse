package baseball;

import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_유저입력문자_길이3미만() {
        assertThatThrownBy(() -> runException("33"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 예외_테스트_유저입력문자_숫자아닌경우() {
        assertThatThrownBy(() -> runException("aa한글"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 예외_테스트_유저입력문자_중복숫자인경우() {
        assertThatThrownBy(() -> runException("332"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_게임종료_문자_예외처리_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123","3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,2,3
        );
    }


    @Test
    void 예외_테스트_게임종료_빈문자_예외처리_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123"," "))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,2,3
        );
    }

    @Test
    void 게임종료_후_재시작_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1","321", "324", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 3, 2, 4
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
