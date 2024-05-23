package kiosk.model;

public class Menu {
    int menuNumber;
    String menuName;
    int price;
    int amount;

    public int getMenuNumber() {
        return menuNumber;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.menuName + " " + this.amount + "개";
    }
}
