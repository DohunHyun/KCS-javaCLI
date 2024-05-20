package kiosk;

public class Drink extends Menu {
    int moreIce;
    int addShot;
    boolean isTogo;

    public Drink() {

    }

    public Drink(int moreIce, int addShot, boolean isTogo) {
        this.moreIce = moreIce;
        this.addShot = addShot;
        this.isTogo = isTogo;
    }

    public int getMoreIce() {
        return moreIce;
    }

    public int getAddShot() {
        return addShot;
    }

    public boolean isTogo() {
        return isTogo;
    }
}
