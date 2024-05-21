package kiosk.model;

public class Ade extends Drink {
    public Ade(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
    }

    public Ade(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
