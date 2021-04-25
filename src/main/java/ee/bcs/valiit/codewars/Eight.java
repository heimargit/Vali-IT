package ee.bcs.valiit.codewars;

import java.util.Arrays;

public class Eight {
    public static void main(String[] args) {

        int[] arr = {6, 5, 1};
        System.out.println(Arrays.toString(sumOfDifferences(new int[]{2, 5, 1})));

    }

    /*
    Ask a small girl -"How old are you?".She always says strange things...Lets help her !
    For correct answer program should return int from 0 to 9.
    Assume test input string always valid and may look like "1 year old" or "5 years old", etc..The first char is number only.
    Ülesanne siin: https://www.codewars.com/kata/557cd6882bfa3c8a9f0000c1/train/java
     */

    public static int howOld(final String herOld) {

        int age = Integer.parseInt(herOld.substring(0, 1));
        return age;
    }

    /*
    Your task is to sum the differences between consecutive pairs in the array in descending order.
    For example:
    sumOfDifferences([2, 1, 10])
    Returns 9
    Descending order: [10, 2, 1]
    Sum: (10 - 2) + (2 - 1) = 8 + 1 = 9
    If the array is empty or the array has only one element the result should be 0 (Nothing in Haskell).
     */

    public static int[] sumOfDifferences(int[] arr) {
        int sum = 0;

        for (int j = 1; j < arr.length - 1; j++) {
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i - 1] < arr[i]) {
                    int theFirstElement = arr[i - 1];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = theFirstElement;
                }
            }
        }
        for (int k = 0; k < arr.length - 1; k++) {
            sum += (arr[k] - arr[k + 1]);
        }
        System.out.println(Arrays.toString(arr));
        return arr;

    }
}
