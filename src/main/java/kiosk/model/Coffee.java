package kiosk.model;

public class Coffee extends Drink {

    public Coffee(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
        super.shots = 2; // 커피 기본 샷 개수
        super.defaultShots = 2;
    }

    public Coffee(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
