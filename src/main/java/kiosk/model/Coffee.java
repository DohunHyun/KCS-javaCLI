package kiosk.model;

import kiosk.controller.MenuListMaker;

public class Coffee extends Drink {
    boolean isLatte; // 우유 종류 변경을 위한 우유 여부
    String milk;
    MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();;

    public Coffee(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
        super.shots = 2; // 커피 기본 샷 개수
        super.defaultShots = 2;
        if(menuListMaker.isCoffeeLatte(menuNumber)) {
            this.isLatte = true;
        } else {
            this.isLatte = false;
        }
    }

    public Coffee(int menuNumber, String menuName, int price, boolean isLatte) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
        this.isLatte = isLatte;
        if(isLatte) {
            this.milk = "우유";
        }
    }

    public boolean getIsLatte() {
        return this.isLatte;
    }

    public void setLatte(String milkInput) {
        if(milkInput.equals("1")) {
            this.milk = "저지방우유";
        } else if(milkInput.equals("2")) {
            this.milk = "두유";
        } else if(milkInput.equals("3")) {
            this.milk = "귀리우유";
        }
    }

    @Override
    public String toString() {
        if(this.isLatte && !this.milk.equals("우유")) {
            if(this.shots > this.defaultShots) {
                return this.menuName + "(" + this.shots + "샷, " + this.milk +" 변경) " + this.amount + "개";
            } else {
                return this.menuName + "(" + this.milk +" 변경) " + this.amount + "개";
            }
        }
        return super.toString();
    }
}
