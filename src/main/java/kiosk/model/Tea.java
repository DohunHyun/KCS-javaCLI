package kiosk.model;

public class Tea extends Drink{
    public Tea(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
    }

    public Tea(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
