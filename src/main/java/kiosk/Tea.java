package kiosk;

public class Tea extends Drink{
    Tea(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
    }

    Tea(int menuNumber, String MenuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
    }
}
