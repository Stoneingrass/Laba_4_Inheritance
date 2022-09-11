package laba2;

public class Item {
    //fields
    private String name;        //item name
    private float price;        //item price

    //constructor
    public Item (String name, float price) {
        this.name=name;
        this.price=price;
        isPriceNegative();
    }

    //getters
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }

    //setters
    public void setName(String name) {
        this.name=name;
    }
    public void setPrice(float price) {
        this.price=price;
        isPriceNegative();
    }

    //methods

    //increase in price by a certain percentage
    public void decreasePrice(float percent) {
        price-=price*percent/100;
        isPriceNegative();
    }

    //decrease in price by a certain percentage
    public void increasePrice(float percent) {
        price+=price*percent/100;
    }

    //private methods

    //price negativity test
    private void isPriceNegative() {
        if (price<0) {
            price=0;
        }
    }
}