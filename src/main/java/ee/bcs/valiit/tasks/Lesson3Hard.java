package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("Guess the number between 0 - 99");
            int guess = scanner.nextInt();
            count++;

            if (guess > randomNumber) {
                System.out.println("The number is smaller");
            } else if (guess < randomNumber) {
                System.out.println("The number is bigger");
            } else {
                System.out.println("You guessed the number! It took you " + count + " times to guess it.");
            }
        }
    }
}
