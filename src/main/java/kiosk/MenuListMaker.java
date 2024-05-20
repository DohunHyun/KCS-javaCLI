package kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuListMaker {
    List<Coffee> coffeeList;

    public MenuListMaker() {
        coffeeList = new ArrayList<>();
        makeMenuList();
    }

    void makeMenuList() {
        makeCoffeeList();
    }

    void makeCoffeeList() {
        coffeeList.add(new Coffee(1, "아이스아메리카노", 4500));
        coffeeList.add(new Coffee(2, "따뜻한아메리카노", 4500));
        coffeeList.add(new Coffee(3, "아이스라떼", 4800));
        coffeeList.add(new Coffee(4, "따뜻한라떼", 4800));
        coffeeList.add(new Coffee(5, "아이스바닐라라떼", 5000));
        coffeeList.add(new Coffee(6, "따뜻한바닐라라떼", 5000));
    }

    public List<Coffee> getCoffeeMenuList() {
        return coffeeList;
    }

    public void printCoffeeMenu() {
        for(Coffee coffee : coffeeList) {
            System.out.println(coffee.menuNumber + ". "
                    + coffee.menuName + " / "
                    + coffee.price);
        }
    }
}
