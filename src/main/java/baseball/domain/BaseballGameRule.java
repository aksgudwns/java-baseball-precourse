package baseball.domain;

public enum BaseballGameRule {

    REPLAY_GAME_USER_INPUT("1"),
    END_GAME_USER_INPUT("2");

    private String value;

    public String getValue() {
        return this.value;
    }

    private BaseballGameRule(String value) {
        this.value = value;
    }
}
