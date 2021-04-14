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
                    "5: Transfer money to another account\n" +
                    "\n" +
                    "Enter the number of action you want to proceed: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // TODO 1
                // Add command: "createAccount ${accountNr}"
                // this has to store accountNr with 0 balance
                System.out.println("Create a new account. \nInsert new account number:");
                String accountNr = scanner.nextLine();
                System.out.println("Insert initial balance:");
                double balance = scanner.nextDouble();
                accountBalanceMap.put(accountNr, balance);

                System.out.println("The new account number is: " + accountNr + "\nThe current balance is " + balance + " €\n");

            } else if (choice == 2) {
                // TODO 2
                // Add command: "getBalance ${accountNr}"
                // this has to display account balance of specific account
                System.out.println("Display account balance. \nInsert the account number:");
                String accountNr = scanner.nextLine();
                double getBalance = accountBalanceMap.get(accountNr);

                System.out.println("The balance of account number " + accountNr + " is:\n" + getBalance + " € \n");

            } else if (choice == 3) {
                // TODO 3
                // Add command: "depositMoney ${accountNr} ${amount}
                // this has to add specified amount of money to account
                // You have to check that amount is positive number
                System.out.println("Add money to an account. \nInsert the account number:");
                String accountNr = scanner.nextLine();
                System.out.println("Insert the amount you want to add:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount > 0) {
                    double balance = accountBalanceMap.get(accountNr);
                    balance = balance + amount;
                    accountBalanceMap.replace(accountNr, balance);
                    System.out.println(amount + " € has been added to account " + accountNr + "\n" +
                            "New balance is: " + balance + " €");
                } else {
                    System.out.println("Invalid request\n");
                }

            } else if (choice == 4) {
                // TODO 4
                // Add command: "withdrawMoney ${accountNr} ${amount}
                // This has to remove specified amount of money from account
                // You have to check that amount is positive number
                // You may not allow this transaction if account balance would become negative
                System.out.println("Withdraw money from an account. \nInsert the account number:");
                String accountNr = scanner.nextLine();
                System.out.println("Insert the withdraw amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                double balance = accountBalanceMap.get(accountNr);

                if (amount > 0 && balance >= amount) {
                    accountBalanceMap.put(accountNr, amount);
                    System.out.println(amount + " has been withdrawn from your account\n");
                } else {
                    System.out.println("Invalid request\n");
                }

            } else if (choice == 5) {
                // TODO 5
                // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                // This has to remove specified amount from fromAccount and add it to toAccount
                // Your application needs to check that toAccount is positive
                // And from account has enough money to do that transaction
                System.out.println("Transfer money to another account. \nInsert the account number FROM which you are doing the transfer:");
                String fromAccount = scanner.nextLine();
                System.out.println("Insert the account number TO which you are doing the transfer:");
                String toAccount = scanner.nextLine();
                System.out.println("Insert the transfer amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                double fromBalance = accountBalanceMap.get(fromAccount);
                double toBalance = accountBalanceMap.get(toAccount);


                if (toBalance >= 0 && fromBalance > 0) {
                    accountBalanceMap.put(fromAccount, fromBalance + amount);
                    accountBalanceMap.put(toAccount, toBalance - amount);
                    System.out.println("The transfer was successful\n");

                } else {
                    System.out.println("The transfer was NOT successful\n");
                }

            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
