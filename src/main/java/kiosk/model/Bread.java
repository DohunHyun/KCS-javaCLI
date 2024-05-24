package kiosk.model;

public class Bread extends Food {
    boolean needCut;
    boolean needWarmUp;
    public Bread(int menuNumber, int amount) {
        super.menuNumber = menuNumber;
        super.amount = amount;
        this.needCut = false;
        this.needWarmUp = false;
    }

    public Bread(int menuNumber, String menuName, int price) {
        super.menuNumber = menuNumber;
        super.menuName = menuName;
        super.price = price;
        this.needWarmUp = false;
        this.needCut = false;
    }

    public void setNeedCut() {
        this.needCut = true;
    }

    public void setNeedWarmUp() {
        this.needWarmUp = true;
    }

    @Override
    public String toString() {
        if(this.needCut && this.needWarmUp) {
            return this.menuName + "(컷팅, 데우기) " + this.amount + "개";
        } else if(this.needCut) {
            return this.menuName + "(컷팅) " + this.amount + "개";
        } else if(this.needWarmUp) {
            return this.menuName + "(데우기) " + this.amount + "개";
        }
        return super.toString();
    }
}
