package kiosk.model;

import kiosk.constant.Constants;

public class Drink extends Menu {
    int moreIce;
    String shots;
    boolean isTogo;
    String defaultShots;

    public Drink() {
        this.moreIce = 0;
        this.shots = Constants.ZERO.getMsg();
        this.isTogo = false;
    }

    public int getMoreIce() {
        return moreIce;
    }

    public String getShots() {
        return shots;
    }

    public boolean isTogo() {
        return isTogo;
    }

    public void addShot(int shots) {
        this.shots = String.valueOf(Integer.parseInt(this.shots) + shots);
    }

    @Override
    public String toString() {
        if(Integer.parseInt(this.shots) > Integer.parseInt(defaultShots)) {
            return this.menuName + "(" + this.shots + "샷) " + this.amount + "개";
        }
        return super.toString();
    }
}
