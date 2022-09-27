package laba4;

/* Describes item class has discount. */

public class ItemWithDiscount extends Item {
    //fields
    private float discount; //discount in money points

    //constructor
    public ItemWithDiscount(String name, float price, float quantity, float discount) {
        super(name, price, quantity);
        this.discount=discount;
    }

    //getters
    public float getDiscount() {
        return discount;
    }

    //setters
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}