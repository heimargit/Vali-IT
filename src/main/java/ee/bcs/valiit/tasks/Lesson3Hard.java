package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args){


    }

    public static String numberGuessGame(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int count = 0;


        while (true){
            System.out.println("Guess the number between 0-99: ");
            int guess = scanner.nextInt();
            count++;

            if (guess < randomNumber){
                return "The number is bigger than "+ guess + ". Guess again!";
            } else if(guess > randomNumber) {
                return "The number is smaller than "+ guess + ". Guess again!";
            } else{
                return "";
            }
        }
        //return "Great, you got it! The number is "+ randomNumber;
    }
}
