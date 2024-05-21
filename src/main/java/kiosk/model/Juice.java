package kiosk.model;

public class Juice extends Drink {
    public Juice(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
    }

    public Juice(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
