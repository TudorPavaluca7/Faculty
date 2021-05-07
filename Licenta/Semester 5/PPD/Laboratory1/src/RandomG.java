import java.util.Random;

public class RandomG {

    private static final String CHAR_LIST =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;

    String generateRandomString() {
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    int getRandomNumber() {
        int randomInt = 0;
        java.util.Random randomGenerator = new java.util.Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt<0)
            randomInt=0-randomInt;
        return randomInt;
    }
}
