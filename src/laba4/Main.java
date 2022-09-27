package laba4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bill bill=new Bill();

        int input;
        boolean isExit=false;

        //choosing customer category
        System.out.println("Are you a regular customer?");
        System.out.println("1. Yes.");
        System.out.println("2. No.");
        System.out.println("3. Exit.");

        input= scanner.nextInt();

        if (input==3) {
            return;
        }

        //creating corresponding bill class
        switch (input) {
            case 1:
                bill = new BillForRegular();
                break;
            case 2:
                bill = new Bill();
                break;
            default:
                System.out.println("You choose incorrect option, retry please.");
        }

        do {

            //available operations with bill
            System.out.println("\nChoose operation you need:");
            System.out.println("1. Create a bill from scratch.");
            System.out.println("2. Add item to the bill.");
            System.out.println("3. Delete item from the bill.");
            System.out.println("4. Output final bill.");
            System.out.println("5. Exit.");
            input= scanner.nextInt();

            switch (input) {
                case 1:
                    bill.inputBill();
                    break;
                case 2:
                    bill.addItem(bill.getItemNumber());
                    break;
                case 3:
                    bill.deleteItem();
                    break;
                case 4:
                    bill.outputBill();
                    break;
                case 5:
                    isExit=true;
                    break;
                default:
                    System.out.println("You choose incorrect option, retry please.");
            }
        } while (!isExit);
    }
}