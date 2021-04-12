package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        //System.out.println(min(1, 3)); // trükib miinimumi 1 ja 3
        //System.out.println(min3(1, 2, 3));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Meil on meetodid:\n1 - min, 2 - max, 3 - abs, 4 - isEven, 5 - min3, 6 - max3.\nVali neist üks meetod ja sisesta konsooli selle meetodi ees olev number:");


        boolean meetodIsAnInt = scanner.hasNextInt();
        if (meetodIsAnInt == true) {

            int meetod = scanner.nextInt(); //loeme sisse kasutaja sisestatud meetodi numbri

            if (meetod == 1 || meetod == 2 || meetod == 3 || meetod == 4 || meetod == 5 || meetod == 6) {
                System.out.println("Sa valisid meetodi: " + meetod);
            } else {
                System.out.println("Sinu sisend ei ole korrektne (arv 1 - 6)");
            }

            if (meetod == 1) {
                System.out.println("Palun sisesta 2 arvväärtust: ");
                int a = scanner.nextInt(); //loeme sisse kasutaja sisestatud arvu nr 1
                int b = scanner.nextInt(); //loeme sisse kasutaja sisestatud arvu nr 2
                System.out.println("Vastus on: " + min(a, b));

            } else if (meetod == 2) {
                System.out.println("Palun sisesta 2 arvväärtust: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Vastus on: " + max(a, b));

            } else if (meetod == 3) {
                System.out.println("Palun sisesta 1 arvväärtus: ");
                int a = scanner.nextInt();
                System.out.println("Vastus on: " + abs(a));

            } else if (meetod == 4) {
                System.out.println("Palun sisesta 1 arvväärtus: ");
                int a = scanner.nextInt();

                if(isEven(a)){
                    System.out.println("Tegemist on paarisarvuga");
                } else {
                    System.out.println("Tegemist on paaritu arvuga");
                }

            } else if (meetod == 5) {
                System.out.println("Palun sisesta 3 arvväärtust: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                System.out.println("Vastus on: " + min3(a, b, c));

            } else if (meetod == 6) {
                System.out.println("Palun sisesta 3 arvväärtust: ");
                scanner.nextLine();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                System.out.println("Vastus on: " + max3(a, b, c));
            }
        }


    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a >= 0) {
            return a;
        } else {
            return -a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if ((a %= 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if ((a <= b) && (a <= c)) {
            return a;
        } else if ((b <= c) && (b <= a)) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if ((a >= b) && (a >= c)) {                 // LAHENDUS 2: return max(max(a, b), c);
            return a;
        } else if ((b >= c) && (b >= a)) {
            return b;
        } else {
            return c;
        }
    }
}
