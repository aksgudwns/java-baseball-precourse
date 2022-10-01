package baseball.vo;

public class UserAnswer {

    private int number1;

    private int number2;

    private int number3;

    public UserAnswer(int number1, int number2, int number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }

    public UserAnswer(){

    }

}
