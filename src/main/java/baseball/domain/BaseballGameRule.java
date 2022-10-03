package baseball.domain;

public enum BaseballGameRule {

    REPLAY("1"),
    END("2");

    private String userInput;

    public String getUserInput() {
        return this.userInput;
    }

    private BaseballGameRule(String userInput) {
        this.userInput = userInput;
    }
}
