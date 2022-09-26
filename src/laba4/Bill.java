package laba4;
/* Describes Bill object contains items. Realized by stack. */

public class Bill {
    //fields
    private ItemWithDiscount[] stack;    //stack of items
    private int itemNumber;    //current number of items in the bill

    //constructor; argument is maximum number of items in the stack
    public Bill(int maxItemNumber) {
        stack=new ItemWithDiscount[maxItemNumber];
        itemNumber=0;
    }


    //getters
    public ItemWithDiscount[] getStack() {
        return stack;
    }
    public int getItemNumber() {
        return itemNumber;
    }




    //public methods (interface)

    //adds an element to the end of the stack (bill)
    public void addItem(ItemWithDiscount item) {
        if (isStackFull()) return;
        stack[itemNumber]=item;
        itemNumber++;
    }
    public void addItem(String name, float price, float quantity) {
        if (isStackFull()) return;
        stack[itemNumber]=new ItemWithDiscount(name, price, quantity, 0);
        itemNumber++;
    }

    //removes the element at the end of the stack (bill)
    public void deleteItem() {
        if (isStackEmpty()) return;
        stack[itemNumber-1]=null;
        itemNumber--;
    }

    //calculates the total cost of items in the bill
    public float sumItemPrice() {
        float sum=0;          //sum of item prices
        for (Item item : stack) {
            sum += item.getPrice();
        }
        return sum;
    }

    //increase the price of all items in the bill by a certain percentage
    public void increaseAllItemPrice(float percent) {
        for (Item item : stack) {
            item.increasePrice(percent);
        }
    }

    //decrease the price of all items in the bill by a certain percentage
    public void decreaseAllItemPrice(float percent) {
        for (Item item : stack) {
            item.decreasePrice(percent);
        }
    }

    //output the bill
    public void outputBill() {
        if(isStackEmpty()) {
            return;
        }
        else {
            String name;
            float quantity, price, amount;
            float sum=0;
            System.out.println("Your bill:");
            for (int i=0; i<itemNumber; i++) {
                name=getStack()[i].getName();
                price=getStack()[i].getPrice();
                quantity=getStack()[i].getQuantity();
                amount=getStack()[i].getQuantity()*getStack()[i].getPrice();
                sum+= amount;
                System.out.println(String.format("%d. %s (%.3f kg(pieces)): $%.2f ($%.2f per kg(piece))", i+1, name, quantity, amount, price));
            }
            System.out.println(String.format("Total amount: ${0}.", sum));
        }
    }




    //private methods

    //checks if the stack is full
    protected boolean isStackFull() {
        boolean error=itemNumber==stack.length;
        if(error) System.out.println("Bill is full.");
        return error;
    }

    //checks if the stack is empty
    protected boolean isStackEmpty() {
        boolean error=itemNumber==0;
        if(error) System.out.println("Bill is empty.");
        return error;
    }

    protected void setItemNumberplus1() {
        itemNumber++;
    }
}