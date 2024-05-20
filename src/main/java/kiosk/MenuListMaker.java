package kiosk;

import java.util.ArrayList;
import java.util.List;

public class MenuListMaker {
    List<Coffee> coffeeList;
    List<Tea> teaList;

    public MenuListMaker() {
        coffeeList = new ArrayList<>();
        teaList = new ArrayList<>();
        makeMenuList();
    }

    void makeMenuList() {
        makeCoffeeList();
        makeTeaList();
    }

    void makeCoffeeList() {
        coffeeList.add(new Coffee(1, "아이스아메리카노", 4500));
        coffeeList.add(new Coffee(2, "따뜻한아메리카노", 4500));
        coffeeList.add(new Coffee(3, "아이스라떼", 4800));
        coffeeList.add(new Coffee(4, "따뜻한라떼", 4800));
        coffeeList.add(new Coffee(5, "아이스바닐라라떼", 5000));
        coffeeList.add(new Coffee(6, "따뜻한바닐라라떼", 5000));
    }

    void makeTeaList() {
        teaList.add(new Tea(1, "아이스녹차", 4000));
        teaList.add(new Tea(2, "따뜻한녹차", 4000));
        teaList.add(new Tea(3, "아이스티", 4000));
        teaList.add(new Tea(4, "아이스페퍼민트", 4000));
        teaList.add(new Tea(5, "따뜻한페퍼민트", 4000));
    }

    public void printCoffeeMenu() {
        for(Coffee coffee : coffeeList) {
            System.out.println(coffee.menuNumber + ". "
                    + coffee.menuName + " / "
                    + coffee.price);
        }
    }

    public void printTeaMenu() {
        for(Tea tea : teaList) {
            System.out.println(tea.menuNumber + ". "
                    + tea.menuName + " / "
                    + tea.price);
        }
    }
}
