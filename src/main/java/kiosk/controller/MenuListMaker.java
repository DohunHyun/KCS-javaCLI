package kiosk.controller;

import kiosk.model.*;

import java.util.ArrayList;
import java.util.List;

public class MenuListMaker {
    List<Coffee> coffeeList;
    List<Tea> teaList;
    List<Cake> cakeList;
    List<Bread> breadList;

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public List<Tea> getTeaList() {
        return teaList;
    }

    public List<Cake> getCakeList() {
        return cakeList;
    }

    public List<Bread> getBreadList() {
        return breadList;
    }

    public MenuListMaker() {
        coffeeList = new ArrayList<>();
        teaList = new ArrayList<>();
        cakeList = new ArrayList<>();
        breadList = new ArrayList<>();
        makeMenuList();
    }

    void makeMenuList() {
        makeCoffeeList();
        makeTeaList();
        makeCakeList();
        makeBreadList();
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

    void makeCakeList() {
        cakeList.add(new Cake(1, "초코케이크", 6000));
        cakeList.add(new Cake(2, "딸기생크림케이크", 6500));
        cakeList.add(new Cake(3, "치즈케이크", 5500));
    }

    void makeBreadList() {
        breadList.add(new Bread(1, "허니브레드", 6000));
        breadList.add(new Bread(2, "소금빵", 3500));
        breadList.add(new Bread(3, "에그샌드위치", 4000));
    }

    public void printCoffeeMenu() {
        for(Coffee coffee : coffeeList) {
            System.out.println(coffee.getMenuNumber() + ". "
                    + coffee.getMenuName() + " / "
                    + coffee.getPrice());
        }
    }

    public void printTeaMenu() {
        for(Tea tea : teaList) {
            System.out.println(tea.getMenuNumber() + ". "
                    + tea.getMenuName() + " / "
                    + tea.getPrice());
        }
    }

    public void printCakeMenu() {
        for(Cake cake : cakeList) {
            System.out.println(cake.getMenuNumber() + ". "
                    + cake.getMenuName() + " / "
                    + cake.getPrice());
        }
    }

    public void printBreadMenu() {
        for(Bread bread : breadList) {
            System.out.println(bread.getMenuNumber() + ". "
                    + bread.getMenuName() + " / "
                    + bread.getPrice());
        }
    }
}
