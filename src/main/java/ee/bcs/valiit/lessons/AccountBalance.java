//package ee.bcs.valiit.lessons;
//
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class AccountBalance {
//
//
//    private static Map<String, Double> accountBalanceMap = new HashMap<>();
//
//    @PostMapping
//    public void createAccount(String accountNr, Double balance) {
//        accountBalanceMap.put(accountNr, balance);
//    }
//
//        // TODO 2
//        // Add command: "getBalance ${accountNr}"
//        // this has to display account balance of specific account
//        System.out.println("Display account balance. \nInsert the account number:");
//
//        double getBalance = accountBalanceMap.get(accountNr);
//
//        System.out.println("The balance of account number " + accountNr + " is:\n" + getBalance + " € \n");
//
//        // TODO 3
//        // Add command: "depositMoney ${accountNr} ${amount}
//        // this has to add specified amount of money to account
//        // You have to check that amount is positive number
//        System.out.println("Add money to an account. \nInsert the account number:");
//
//        System.out.println("Insert the amount you want to add:");
//        double amount = scanner.nextDouble();
//        scanner.nextLine();
//
//        if (amount > 0) {
//            double balance = accountBalanceMap.get(accountNr);
//            balance = balance + amount;
//            accountBalanceMap.replace(accountNr, balance);
//            System.out.println(amount + " € has been added to account " + accountNr + "\n" +
//                    "New balance is: " + balance + " €\n");
//        } else {
//            System.out.println("Invalid request\n");
//        }
//
//    } else if(choice ==4)
//
//    {
//        // TODO 4
//        // Add command: "withdrawMoney ${accountNr} ${amount}
//        // This has to remove specified amount of money from account
//        // You have to check that amount is positive number
//        // You may not allow this transaction if account balance would become negative
//        System.out.println("Withdraw money from an account. \nInsert the account number:");
//        String accountNr = scanner.nextLine();
//        System.out.println("Insert the withdraw amount:");
//        double amount = scanner.nextDouble();
//        scanner.nextLine();
//        double balance = accountBalanceMap.get(accountNr);
//
//        if (amount > 0 && balance >= amount) {
//            //accountBalanceMap.put(accountNr, amount);
//            System.out.println(amount + " has been withdrawn from your account\n" +
//                    "The new balance is " + (accountBalanceMap.put(accountNr, amount)) + " €.\n");
//        } else {
//            System.out.println("Invalid request\n");
//        }
//
//    } else if(choice ==5)
//
//    {
//        // TODO 5
//        // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
//        // This has to remove specified amount from fromAccount and add it to toAccount
//        // Your application needs to check that toAccount is positive
//        // And from account has enough money to do that transaction
//        System.out.println("Transfer money to another account. \nInsert the account number FROM which you are doing the transfer:");
//        String fromAccount = scanner.nextLine();
//        System.out.println("Insert the transfer amount:");
//        double transferAmount = scanner.nextDouble();
//        scanner.nextLine();
//
//
//        if (transferAmount > 0) {
//            if (transferAmount < accountBalanceMap.get(fromAccount)) {
//                System.out.println("Insert the account number TO which you are doing the transfer:");
//                String toAccount = scanner.nextLine();
//                System.out.println("The transfer was successful.\n" +
//                        "New balance is: " + (accountBalanceMap.get(fromAccount) - transferAmount) + " €\n");
//
//            } else {
//                System.out.println("The transfer was NOT successful\n");
//            }
//        } else {
//            System.out.println("Invalid request\n");
//        }
////
//    }
//}
//    }
//            }
