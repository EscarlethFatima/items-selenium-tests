package utils;

import java.util.Random;

public  final class StringHelper {
    public  static  String generateRandomString(int stringLength){
        final String alphabet = "0123456789ABCDE";
        final int N = alphabet.length();
        StringBuilder string = new StringBuilder();

        Random r = new Random();

        for (int i = 0; i < stringLength; i++) {
            string.append(alphabet.charAt(r.nextInt(N)));
        }
        return string.toString();
    }
}
