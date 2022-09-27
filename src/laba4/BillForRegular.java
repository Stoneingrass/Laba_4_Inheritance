package laba4;

/* Describes Bill object contains items. */

import java.util.Locale;
import java.util.Scanner;

public class BillForRegular extends Bill {
    //no fields

    //constructor
    public BillForRegular() {
        super();
    }


    //public methods
    @Override
    public void addItem(String name, float price, float quantity, float discount) {
        if (isBillFull()) return;
        if (!isBillCreated()) return;
        getBill()[getItemNumber()]=new ItemWithDiscount(name, price, quantity, discount);
        itemNumber++;
    }

    //output the bill
    @Override
    public void outputBill() {
        if(isBillEmpty()) {
            return;
        }

        String name;
        float quantity, price, amount, discount, discountAmount, cost;
        int itemsDiscounted=0;
        float totalAmount=0, totalDiscountAmount=0, totalCost=0;
        System.out.println("Your bill (for regular customer):");
        for (int i=0; i<getItemNumber(); i++) {
            name= getBill()[i].getName();
            price= getBill()[i].getPrice();
            quantity= getBill()[i].getQuantity();
            amount= getBill()[i].getQuantity()* getBill()[i].getPrice();
            discount= getBill()[i].getDiscount();
            discountAmount= getBill()[i].getDiscount()* getBill()[i].getQuantity();
            cost=amount-discountAmount;

            totalAmount+=amount;
            totalDiscountAmount+=discountAmount;
            totalCost+=cost;
            if(discount!=0) {
                itemsDiscounted++;
            }

            System.out.printf(Locale.ROOT,"%d. %s (%.3f kg(pieces); $%.2f per kg(piece)): $%.2f - $%.2f ($%.2f per kg(piece)) = $%.2f%n", i+1, name, quantity, price, amount, discountAmount, discount, cost);
        }
        System.out.printf(Locale.ROOT,"Total amount: $%.2f - $%.2f (discount) = $%.2f. Items with discount: %d items.%n", totalAmount, totalDiscountAmount, totalCost, itemsDiscounted);
    }


    //protected methods
    @Override
    protected float setItemDiscount(int i) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input discount of item #" + (i + 1));
        return scanner.nextFloat();
    }
}