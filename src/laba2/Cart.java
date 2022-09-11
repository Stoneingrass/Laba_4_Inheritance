package laba2;
/*
добавить проверку на переполнение стека
 */

public class Cart {
    //fields
    private Item[] stack;       //stack of items
    private int itemNumber;     //current number of items in the cart

    //constructor; argument is maximum number of items in the stack
    public Cart(int maxItemNumber) {
        stack=new Item[maxItemNumber];
        itemNumber=0;
    }

    //public methods

    //adds an element to the end of the stack (cart)
    public void addItem(Item item) {
        stack[itemNumber]=item;
        itemNumber++;
    }

    //removes the element at the end of the stack (cart)
    public void deleteItem(Item item) {
        stack[itemNumber-1]=null;
        itemNumber--;
    }

    //calculates the total cost of items in the cart
    public float sumItemPrice() {
        int sum=0;          //sum of item prices
        for (int i=0; i<stack.length; i++) {
            sum+=stack[i].getPrice();
        }
        return sum;
    }

    //increase the price of all items in the cart by a certain percentage
    public void increaseAllItemPrice(float percent) {
        for (int i=0; i<stack.length; i++) {
            stack[i].increasePrice(percent);
        }
    }

    //decrease the price of all items in the cart by a certain percentage
    public void decreaseAllItemPrice(float percent) {
        for (int i=0; i<stack.length; i++) {
            stack[i].decreasePrice(percent);
        }
    }

    //private methods

    //checks if the stack is full
    private boolean isStackFull() {
        return itemNumber==stack.length;
    }

    //checks if the stack is empty
    private boolean isStackEmpty() {
        return itemNumber==0;
    }
}
