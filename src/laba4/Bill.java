package laba4;

/* Describes Bill object contains items. */

import java.util.Locale;
import java.util.Scanner;

public class Bill {
    //fields
    protected ItemWithDiscount[] bill;    //stack of items
    protected int itemNumber;    //current number of items in the bill

    //constructor
    public Bill() {
        itemNumber=0;
    }

    //getters
    public ItemWithDiscount[] getBill() {
        return bill;
    }
    public int getItemNumber() {
        return itemNumber;
    }




    //public methods (interface)

    //adds an item to the end of the bill
    public void addItem(ItemWithDiscount item) {
        if (isBillFull()) return;
        bill[itemNumber]=item;
        itemNumber++;
    }
    public void addItem(String name, float price, float quantity, float discount) {
        if (isBillFull()) return;
        bill[itemNumber]=new ItemWithDiscount(name, price, quantity, 0);
        itemNumber++;
    }
    //console interface of addItem
    public void addItem(int i) {
        if (!isBillCreated()) return;
        if (isBillFull()) return;
        Scanner nameScanner = new Scanner(System.in);
        Scanner numberScanner = new Scanner(System.in);

        System.out.println("\nInput name of item #" + (i + 1));
        String name = nameScanner.nextLine();
        System.out.println("Input price of item #" + (i + 1));
        float price = numberScanner.nextFloat();
        System.out.println("Input quantity of item #" + (i + 1));
        float quantity = numberScanner.nextFloat();

        float discount=setItemDiscount(i);

        addItem(name, price, quantity, discount);
    }

    //removes the item by index
    public void deleteItem(int n) {
        if (isBillEmpty()) return;
        for (int i=n; i<itemNumber-1; i++) {
            bill[i]=bill[i+1];
        }
        bill[itemNumber-1]=null;
        itemNumber--;
    }
    //console interface of deleteItem
    public void deleteItem() {
        if (isBillEmpty()) return;
        Scanner numberScanner = new Scanner(System.in);

        int index;
        do {
            System.out.printf("Input index of item which you want to delete (1..%d)%n", itemNumber);
            index = numberScanner.nextInt();
            if (index <= 0 || index > itemNumber) System.out.println("Please, input a correct number (1..%d).");
        } while (index <= 0 || index > itemNumber);

        deleteItem(index-1);
    }

    //calculates the total cost of items in the bill
    public float sumItemPrice() {
        float sum=0;          //sum of item prices
        for (ItemWithDiscount item : bill) {
            sum += item.getPrice();
        }
        return sum;
    }

    //increase the price of all items in the bill by a certain percentage
    public void increaseAllItemPrice(float percent) {
        if (isBillEmpty()) return;
        for (Item item : bill) {
            item.increasePrice(percent);
        }
    }

    //decrease the price of all items in the bill by a certain percentage
    public void decreaseAllItemPrice(float percent) {
        if (isBillEmpty()) return;
        for (Item item : bill) {
            item.decreasePrice(percent);
        }
    }

    //input the bill
    public void inputBill() {
        itemNumber=0;
        int itemMaxNumber;  //maximum item number in the bill
        int itemInputNumber;  //number of items user want to input
        Scanner numberScanner = new Scanner(System.in);

        //input maximum number of items in the bill
        do {
            System.out.println("Input maximum items number in the bill (>0):");
            itemMaxNumber = numberScanner.nextInt();
            if (itemMaxNumber <= 0) System.out.println("Please, input a number more than 0.");
        } while (itemMaxNumber <= 0);

        //input number of items user want to input
        do {
            System.out.printf("Input items number you want to input (1..%d):%n", itemMaxNumber);
            itemInputNumber = numberScanner.nextInt();
            if (itemInputNumber < 1 || itemInputNumber > itemMaxNumber) System.out.println("Please, input a number more than 0.");
        } while (itemInputNumber < 1 || itemInputNumber > itemMaxNumber);

        //item array initialisation
        bill = new ItemWithDiscount[itemMaxNumber];

        //bill filling by items
        for (int i = 0; i < itemInputNumber; i++) {
            addItem(i);
        }
    }

    //output the bill
    public void outputBill() {
        if(isBillEmpty()) {
            return;
        }
        String name;
        float quantity, price, amount;
        float sum=0;
        System.out.println("Your bill:");
        for (int i=0; i<itemNumber; i++) {
            name= getBill()[i].getName();
            price= getBill()[i].getPrice();
            quantity= getBill()[i].getQuantity();
            amount= getBill()[i].getQuantity()* getBill()[i].getPrice();
            sum+= amount;
            System.out.printf(Locale.ROOT,"%d. %s \t (%.3f kg(pieces); $%.2f per kg(piece)): \t $%.2f.%n", i+1, name, quantity, price, amount);
        }
        System.out.printf(Locale.ROOT,"Total amount: $%.2f.%n", sum);
    }




    //protected methods

    //checks if the bill is full
    protected boolean isBillFull() {
        boolean error=itemNumber== bill.length;
        if(error) System.out.println("Bill is full.");
        return error;
    }

    //checks if the bill is empty
    protected boolean isBillEmpty() {
        boolean error=(itemNumber==0);
        if(error) System.out.println("Bill is empty.");
        return error;
    }

    //checks if the bill created
    protected boolean isBillCreated() {
        boolean isCreated=!(bill==null);
        if(!isCreated) System.out.println("At first please create a bill!");
        return isCreated;
    }

    //sets discount for items (default 0, for regular customers see overridden function in BillForRegular)
    protected float setItemDiscount(int i) {
        return 0;
    }
}