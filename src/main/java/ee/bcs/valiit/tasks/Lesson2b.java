package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {
    public static void main(String[] args) {
        System.out.println(exercise1(6));

    }

    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static int exercise1(int n) {
        int[] array = new int[n];

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " ");
        }
        return n;


/* LAHENDUS 2:
        int i = 1;

        while (i <= n) {
            System.out.println(i + " ");
            i++;
        }
        return i;
*/

    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] x = {1, 2, 3, 4, 5};
        return x;



        /*LAHENDUSVARIANT 2:

        return newArray []{1, 2, 3, 4, 5};
        */
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {

        int[] newArray = new int[n]; //defineerin uue array, kus on n elementi (nt 5)

        for (int i = 0; i < n; i++) { //Loon tsükli, mis algustab esimesest elemendist kuni n-elemendini (nt 5nda elemendini k.a.)
            newArray[i] = i + 1; //Tahan, et arrays olevad elemendid n
        }
        return newArray;

        /*LAHENDUSVARIANT 2:

        int[] newArray = new int[n];
        int index = 0;

        for(int i = 0; i < n; i++){
            newArray[index] = i;
            index++;
        }
         */
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: sisend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {

        int[] newArray = new int[Math.abs(n) + 1];
        //int number = 0;

        if (n >= 0) {
            for (int i = 0; i <= n; i--) {
                newArray[i] = n - i;
                i++;
            }
        } else {
            for (int i = -n; i >= 0; i++) {
                newArray[i] = n + i;
                i++;
            }
        }
        return newArray;

    }


        /*LAHENDUSVARIANT 2:

        if (n >= 0) {
            int[] newArray = new int[n+1];
            int index = 0;

            for (int i = n; i >= 0; i--) {
                newArray[index] = i;
                index++;
            }
        } else {
            int maxIndex = -n
            int[] newArray = new int[maxIndex+1];
            for (int i = 0; i >= n; i++) {
                newArray[maxIndex] = i;
                maxIndex--;

         */

          /*LAHENDUSVARIANT 3:
          int[] newArray = new int[Math.abs(n)+1];
          int index = 0;

          while (n != 0){
            if(n > 0) {
                newArray[index] = n--;
            } else {
                newArray[index] = n++;
          }
            index++;
          }
          return newArray;

         */


    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {

        int[] newArray = new int[n];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = 3;
        }
        return newArray;
    }
}
