package kiosk.model;

public class Drink extends Menu {
    int moreIce;
    int shots;
    boolean isTogo;
    int defaultShots;

    public Drink() {
        this.moreIce = 0;
        this.shots = 0;
        this.isTogo = false;
    }

    public int getMoreIce() {
        return moreIce;
    }

    public int getAddShot() {
        return shots;
    }

    public boolean isTogo() {
        return isTogo;
    }

    public void addShot(int shots) {
        this.shots += shots;
    }

    @Override
    public String toString() {
        if(this.shots > defaultShots) {
            return this.menuName + "(" + this.shots + "샷) " + this.amount + "개";
        }
        return super.toString();
    }
}
