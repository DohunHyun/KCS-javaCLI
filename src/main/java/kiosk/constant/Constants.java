package kiosk.constant;

public enum Constants {
    ZERO("0"),

    INPUT_ONE("1"),
    INPUT_TWO("2"),
    INPUT_THREE("3"),
    INPUT_FOUR("4"),

    DEFAULT_SHOTS("2"),

    DRINK("음료"),
    FOOD("음식"),
    COFFEE("커피"),
    TEA("차"),
    JUICE("주스"),
    ADE("에이드"),
    CAKE("케이크"),
    BREAD("빵"),

    MILK("우유"),
    LOWFAT_MILK("저지방우유"),
    SOY_MILK("두유"),
    OAT_MILK("귀리우유"),

    WRONG_INPUT_MSG("잘못된 입력입니다.");

    private final String msg;

    Constants(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
