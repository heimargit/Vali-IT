package ee.bcs.valiit.codewars;

public class eight_1 {
    public static void main(String[] args) {
//        Ask a small girl -"How old are you?".She always says strange things...Lets help her !
//        For correct answer program should return int from 0 to 9.
//        Assume test input string always valid and may look like "1 year old" or "5 years old", etc..The first char is
//        number only.
//        Ülesanne siin: https://www.codewars.com/kata/557cd6882bfa3c8a9f0000c1/train/java

        //ehk tagasta Stringi esimene character int-kujul
    }

    public static int howOld(final String herOld) {

        int age = Integer.parseInt(herOld.substring(0, 1));
        return age;
    }

}
