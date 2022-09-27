package laba4;

/* Describes item object has a name and a price */

public class Item {
    //fields
    private String name;    //item name
    private float price;    //item price
    private float quantity; //item quantity

    //constructor
    public Item (String name, float price, float quantity) {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        nullingPriceIfPriceIsNegative();
    }

    //getters
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public float getQuantity() {
        return quantity;
    }

    //setters
    public void setName(String name) {
        this.name=name;
    }
    public void setPrice(float price) {
        this.price=price;
        nullingPriceIfPriceIsNegative();
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }




    //public methods (interface)

    //decrease in price by a certain percentage
    public void decreasePrice(float percent) {
        price-=price*percent/100;
        nullingPriceIfPriceIsNegative();
    }

    //increase in price by a certain percentage
    public void increasePrice(float percent) {
        price+=price*percent/100;
        nullingPriceIfPriceIsNegative();
    }




    //private methods

    //price negativity test
    private void nullingPriceIfPriceIsNegative() {
        if (price<0) {
            price=0;
        }
    }
}