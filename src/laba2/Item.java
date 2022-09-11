package laba2;

/* Describes item object has a name and a price */
public class Item {
    //fields
    private String name;    //item name
    private float price;    //item price

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


    //public methods (interface)

    //decrease in price by a certain percentage
    public void decreasePrice(float percent) {
        decrease(percent);
    }
    private void decrease(float percent) {
        price-=price*percent/100;
        isPriceNegative();
    }

    //increase in price by a certain percentage
    public void increasePrice(float percent) {
        increase(percent);
    }
    private void increase(float percent) {
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