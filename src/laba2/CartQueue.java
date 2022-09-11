package laba2;

/* Describes Cart object contains items */

public class CartQueue {
    //fields
    private Item[] stack;    //stack of items
    private int itemNumber;    //current number of items in the cart

    //constructor; argument is maximum number of items in the stack
    public CartQueue(int maxItemNumber) {
        stack=new Item[maxItemNumber];
        itemNumber=0;
    }


    //getters
    public Item[] getStack() {
        return stack;
    }
    public int getItemNumber() {
        return itemNumber;
    }


    //public methods (interface)

    //adds an element to the end of the stack (cart)
    public void addItem(Item item) {
        add(item);
    }
    private void add(Item item) {
        if (isStackFull ()) return;
        for (int i=itemNumber-1; i>=0; i--) {
            stack[i+1]=stack[i];
        }
        stack[0]=item;
        itemNumber++;
    }

    //removes the element at the end of the stack (cart)
    public void deleteItem() {
        delete();
    }
    private void delete() {
        if (isStackEmpty()) return;
        for (int i=0; i<itemNumber-1; i++) {
            stack[i]=stack[i+1];
        }
        stack[itemNumber-1]=null;
        itemNumber--;
    }

    //calculates the total cost of items in the cart
    public float sumItemPrice() {
        return sum();
    }
    private float sum() {
        float sum=0;          //sum of item prices
        for (Item item : stack) {
            sum += item.getPrice();
        }
        return sum;
    }

    //increase the price of all items in the cart by a certain percentage
    public void increaseAllItemPrice(float percent) {
        increase(percent);
    }
    private void increase(float percent) {
        for (Item item : stack) {
            item.increasePrice(percent);
        }
    }

    //decrease the price of all items in the cart by a certain percentage
    public void decreaseAllItemPrice(float percent) {
        decrease(percent);
    }
    private void decrease(float percent) {
        for (Item item : stack) {
            item.decreasePrice(percent);
        }
    }


    //private methods

    //checks if the stack is full
    private boolean isStackFull() {
        boolean error=itemNumber==stack.length;
        if(error) System.out.println("Cart is full.");
        return error;
    }

    //checks if the stack is empty
    private boolean isStackEmpty() {
        boolean error=itemNumber==0;
        if(error) System.out.println("Cart is empty.");
        return error;
    }
}