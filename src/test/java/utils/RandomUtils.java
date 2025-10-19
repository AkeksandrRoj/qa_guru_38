package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;




public class RandomUtils {

    public static void main(String[] args) {

        System.out.println(getRandomString(5));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(10, 55));
        System.out.println(getRandomPhone());
    }

    public static String getRandomString(int value) {
        // String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String getRandomEmail() {

        return getRandomString(5) + "@" + "email.org";
    }

    public static String getRandomAddress() {

        return "st " + getRandomString(5) + " " + getRandomString(5) + " " + getRandomString(5);
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
    // +7 (985) 426 25-14
    public static String getRandomPhone() {

        return String.format("+ (%s) %s - %s - %s",getRandomInt(1, 9),getRandomInt(100, 999),getRandomInt(10, 99),getRandomInt(10, 99));
    }


}

