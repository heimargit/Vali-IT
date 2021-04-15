package ee.bcs.valiit.lessons;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4b {

    // Store account nr as a key and account balance as value

    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Insert command");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            } else if (line.equalsIgnoreCase("createAccount")) {
                System.out.println("Please enter account nr");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter inital balance");
                Double balance = scanner.nextDouble();
                scanner.nextLine();
                accountBalanceMap.put(accountNr, balance);
            } else if (line.equalsIgnoreCase("getBalance")) {
                System.out.println("Please enter account nr");
                String accountNr = scanner.nextLine();
                System.out.println("Konto balanss on: " + accountBalanceMap.get(accountNr));
            }

            if (line.equalsIgnoreCase("depositMoney")) {
                System.out.println("Please enter account nr");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter amount");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    Double currentBalance = accountBalanceMap.get(accountNr);
                    Double newBalance = currentBalance + amount;
                    accountBalanceMap.put(accountNr, newBalance);
                } else {
                    System.out.println("Sisestatud summa peab olema positiivne number");
                }
            } else if (line.equalsIgnoreCase("withdrawMoney")) {
                System.out.println("Please enter account nr");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter amount");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    Double currentBalance = accountBalanceMap.get(accountNr);
                    Double newBalance = currentBalance - amount;
                    if (newBalance >= 0) {
                        accountBalanceMap.put(accountNr, newBalance);
                    } else {
                        System.out.println("Kontol pole piisavalt raha");
                    }
                } else {
                    System.out.println("Sisestatud summa peab olema positiivne number");
                }
            } else if (line.equalsIgnoreCase("transferMoney")) {
                System.out.println("Please enter from account nr");
                String fromAccountNr = scanner.nextLine();
                System.out.println("Please enter to account nr");
                String toAccountNr = scanner.nextLine();
                System.out.println("Please enter amount");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    double fromAccountBalance = accountBalanceMap.get(fromAccountNr);
                    if (fromAccountBalance < amount) {
                        System.out.println("Kontol pole piisavalt raha");
                    } else {
                        double toAccountBalance = accountBalanceMap.get(toAccountNr);
                        accountBalanceMap.put(fromAccountNr, fromAccountBalance - amount);
                        accountBalanceMap.put(toAccountNr, toAccountBalance + amount);
                    }
                } else {
                    System.out.println("Summa peab olema positiivne number");
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }

}
