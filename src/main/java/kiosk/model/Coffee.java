package kiosk.model;

public class Coffee extends Drink {

    public Coffee(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
    }

    public Coffee(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
