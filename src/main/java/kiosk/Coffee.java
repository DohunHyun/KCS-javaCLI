package kiosk;

public class Coffee extends Drink {

    Coffee(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
    }

    Coffee(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
