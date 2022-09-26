package laba4;

//bills for regular customers with discounts
public class BillForRegular extends Bill {
    //constructor
    public BillForRegular(int maxItemNumber) {
        super(maxItemNumber);
    }


    //public methods
    public void addItem(String name, float price, float quantity, float discount) {
        if (isStackFull()) return;
        getStack()[getItemNumber()]=new ItemWithDiscount(name, price, quantity, discount);
        setItemNumberplus1();
    }

    @Override
    //output the bill
    public void outputBill() {
        if(isStackEmpty()) return;

        String name;
        float quantity, price, amount, discount, discountAmount, cost;
        int itemsDiscounted=0;
        float totalAmount=0, totalDiscountAmount=0, totalCost=0;
        System.out.println("Your bill (for regular customer:");
        for (int i=0; i<getItemNumber(); i++) {
            name=getStack()[i].getName();
            price=getStack()[i].getPrice();
            quantity=getStack()[i].getQuantity();
            amount=getStack()[i].getQuantity()*getStack()[i].getPrice();
            discount=getStack()[i].getDiscount();
            discountAmount=getStack()[i].getDiscount()*getStack()[i].getQuantity();
            cost=amount-discountAmount;

            totalAmount+=amount;
            totalDiscountAmount+=discountAmount;
            totalCost+=cost;
            if(discount!=0) {
                itemsDiscounted++;
            }

            System.out.println(String.format("%d. %s (%.3f kg(pieces)): $%.2f ($%.2f per kg(piece)) - $%.2f ($%.2f per kg(piece)) = $%.2f", i+1, name, quantity, amount, price, discount, discountAmount, cost));
        }
        System.out.println(String.format("Total amount: ${%.2f - $%.2f (discount) = $%.2f. Items with discount: %d items.", totalAmount, totalDiscountAmount, totalCost, itemsDiscounted));
    }


}
