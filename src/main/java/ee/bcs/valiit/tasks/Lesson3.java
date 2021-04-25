package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson3 {

    public static void main(String[] args) {
        //System.out.println(factorial(5));
        System.out.println(reverseString("tere"));
        //System.out.println(Arrays.toString(sort(new int[]{4, 2, 6, 7, 1})));
        //System.out.println(morseCode("hello"));

    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int f = 1;

        for (int i = 1; i <= x; i++) {
            f = f * i;
        }
        return f;

    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {

        String reverseA = "";

        for (int i = a.length() - 1; i >= 0; i--) {
            reverseA += a.charAt(i);
        }
        System.out.println("String " + a + " on tagurpidi kirjutatuna " + reverseA);
        return reverseA;

    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {

        if (x == 1) {
            return false;
        }

        for (int i = 2; i < x; i++) {
            if ((x % i) == 0) {  //kontrollin jagatise jääki
                return false;
            }
        }
        return true;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {

        for (int j = 1; j < a.length - 1; j++) {
            for (int i = 1; i < a.length - 1; i++) {  //
                if (a[i-1] > a[i]) {
                    int theSmallest = a[i-1];  //defineerin a[0] kui kõige väiksema väärtusega arvu asukoha
                    a[i] = a[i -1];         //et väikseim arv (a[0]) on suurem, kui tema kõrval olev arv, siis liigutan a[0]-i edasi (vahetan kohad, st liigutan suurema arvu edasi)
                    a[i - 1] = theSmallest;  //nüüd on a[i+1] asukohal väikseim arv
                }
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }


    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int sumF = 0;
        int a = 0;
        int b = 1;
        int fib = 0;

        while (a + b <= x) {
            a = b;
            b = fib;
            fib = a + b;

            if (fib % 2 == 0) {
                sumF += fib;
            }
        }
        return sumF;
    }


    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga

        Map<String, String> morse = new HashMap<>();
        String textMorse = "";

        for (int i = 0; i < text.length(); i++) {
            morse.put("a", ".-");
            morse.put("h", "....");
            morse.put("e", ".");
            morse.put("l", ".-..");
            morse.put("o", "---");
            morse.put("s", "...");

            String m = text.substring(i, i + 1);
            textMorse = textMorse + morse.get(m) + " ";
        }
        return textMorse.trim();

    }
}
