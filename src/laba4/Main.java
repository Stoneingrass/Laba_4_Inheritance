package laba4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bill bill;

        int input;
        boolean isExit=false;

        do {
            System.out.println("\nAre you a regular customer?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println("3. Exit.");

            input= scanner.nextInt();

            switch (input) {
                case 1:

                    break;
                case 2:


                    break;
                case 3:
                    isExit=true;
                    break;
                default:
                    System.out.println("You choose incorrect option, retry please.");
            }
        } while (!isExit);

    }
/*
    //adding items to Bill
    public static Bill inputItems() {


        int itemNumber;
        Bill basket;
        Scanner nameScanner = new Scanner(System.in);
        Scanner numberScanner = new Scanner(System.in);

        //input number of items in the cart
        do {
            System.out.println("Input items number in the cart (>0):");
            itemNumber = numberScanner.nextInt();
            if (itemNumber <= 0) System.out.println("Please, input a number more than 0.");
        } while (itemNumber <= 0);

        //cart initialisation
        basket = new Bill(itemNumber);

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
    public static void outputCart (Bill basket) {
        for (int i=0; i<basket.getItemNumber(); i++) {
            System.out.println("Item #" + (i + 1) + ": " + basket.getStack()[i].getName() + " - " + basket.getStack()[i].getPrice());
        }
    }
    */
}