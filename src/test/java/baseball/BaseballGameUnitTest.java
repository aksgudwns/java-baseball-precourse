package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameResult;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameUnitTest extends NsTest {

    @Test
    void 쓰리스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.initializeGame();
                    baseballGame.setResult("123");
                    BaseballGameResult result = baseballGame.getResult();
                    assertThat(result.getStrike() == 3 && result.getBall() == 0).isTrue();
                },
                1, 2,3
        );
    }

    @Test
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.initializeGame();
                    baseballGame.setResult("123");
                    BaseballGameResult result = baseballGame.getResult();
                    assertThat(result.getStrike() == 0 && result.getBall() == 0).isTrue();
                },
                4,5,6
        );
    }


    @Test
    void 원스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.initializeGame();
                    baseballGame.setResult("123");
                    BaseballGameResult result = baseballGame.getResult();
                    assertThat(result.getStrike() == 1 && result.getBall() == 0).isTrue();
                },
                1, 4,5
        );
    }


    @Test
    void 원볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.initializeGame();
                    baseballGame.setResult("123");
                    BaseballGameResult result = baseballGame.getResult();
                    assertThat(result.getStrike() == 0 && result.getBall() == 1).isTrue();
                },
                2, 4,5
        );
    }


    @Test
    void 원스트라이크_원볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.initializeGame();
                    baseballGame.setResult("123");
                    BaseballGameResult result = baseballGame.getResult();
                    assertThat(result.getStrike() == 1 && result.getBall() == 1).isTrue();
                },
                2, 4,3
        );
    }

    @Override
    protected void runMain() {

    }
}
