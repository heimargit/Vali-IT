package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Lesson4 {
    // Store account nr as a key and account balance as value
    // HashMap<String, Account> accountBalanceMap = new HashMap<>();

    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("The available actions are:\n" +
                    "1: Create a new account\n" +
                    "2: Display account balance\n" +
                    "3: Add money to an account\n" +
                    "4: Withdraw money from an account\n" +
                    "5: Transfer money to another account\n"+
                    "\n"+
                    "Enter the number of action you want to proceed: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                System.out.println("Create a new account. \nInsert new account number:");
                String accountNr = scanner.nextLine();
                System.out.println("Insert initial balance:");
                Double balance = scanner.nextDouble();
                accountBalanceMap.put(accountNr, balance);

                System.out.println("The new account number is: "+ accountNr +"\nThe current balance is "+ balance + " €");

            } else if (choice == 2){
                System.out.println("Display account balance. \nInsert the account number:");
                String accountNr = scanner.nextLine();

                System.out.println("The balance of account number "+ accountNr + " is:\n"+ accountBalanceMap.get(accountNr));

            } else if (choice == 3){
                System.out.println("Add money to an account. \nInsert the account number:");
                String accountNr = scanner.nextLine();
                System.out.println("Insert the amount of money you want to add:");
                Double depositMoney = scanner.nextDouble();
                scanner.nextLine();

                if (depositMoney > 0){
                    System.out.println(accountBalanceMap.put(accountNr,depositMoney) + " has been added to your account.");

                } else {
                    System.out.println("This is not a valid amount.");
                }

            } else if (choice == 4){
                System.out.println("Withdraw money from an account. \nInsert the account number:");
                String accountNr = scanner.nextLine();
                Double withdrawMoney = scanner.nextDouble();
                scanner.nextLine();


            } else if (choice == 5) {
                System.out.println("Transfer money to another account. \nInsert your account number:");
                String accountNr = scanner.nextLine();


            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific account
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction
            else {
                System.out.println("Unknown command");
            }
        }
    }
}
