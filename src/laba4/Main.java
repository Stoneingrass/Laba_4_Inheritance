package laba4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cart basket;

        basket = inputItems();

        System.out.println("\nThe cart:");
        outputCart(basket);

        System.out.println("Sum of prices of all items in the cart: " + basket.sumItemPrice());

        System.out.println("\nIncreasing a price by 15%: ");
        basket.increaseAllItemPrice(15);
        outputCart(basket);
        System.out.println("Sum of prices of all items in the cart: " + basket.sumItemPrice());

        System.out.println("\nDecreasing a price by 30%: ");
        basket.decreaseAllItemPrice(30);
        outputCart(basket);
        System.out.println("Sum of prices of all items in the cart: " + basket.sumItemPrice());
    }

    //adding items to cart
    public static Cart inputItems() {
        int itemNumber;
        Cart basket;
        Scanner nameScanner = new Scanner(System.in);
        Scanner numberScanner = new Scanner(System.in);

        //input number of items in the cart
        do {
            System.out.println("Input items number in the cart (>0):");
            itemNumber = numberScanner.nextInt();
            if (itemNumber <= 0) System.out.println("Please, input a number more than 0.");
        } while (itemNumber <= 0);

        //cart initialisation
        basket = new Cart(itemNumber);

        //cart filling by items
        for (int i = 0; i < itemNumber; i++) {
            System.out.println("\nInput name of item #" + (i + 1));
            String name = nameScanner.nextLine();
            System.out.println("Input price of item #" + (i + 1));
            float price = numberScanner.nextFloat();

            basket.addItem(new Item(name, price));
        }

        return basket;
    }

    //outputting of the cart
    public static void outputCart (Cart basket) {
        for (int i=0; i<basket.getItemNumber(); i++) {
            System.out.println("Item #" + (i + 1) + ": " + basket.getStack()[i].getName() + " - " + basket.getStack()[i].getPrice());
        }
    }
}