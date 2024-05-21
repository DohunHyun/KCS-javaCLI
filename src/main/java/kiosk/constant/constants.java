package kiosk.constant;

public enum constants {
    INPUT_ONE("1"),
    INPUT_TWO("2"),
    INPUT_THREE("3"),
    INPUT_FOUR("4"),

    WRONG_INPUT_MSG("잘못된 입력입니다.");

    private String msg;

    constants(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
