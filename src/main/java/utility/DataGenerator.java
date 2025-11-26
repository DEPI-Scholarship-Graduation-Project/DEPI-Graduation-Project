package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGenerator {

    private static final Random rand = new Random();

    private static String timeSuffix() {
        return DateTimeFormatter.ofPattern("HHmmssSSS").format(LocalDateTime.now());
    }

    // random gender, return random true, false
    public static String randomGender() {
        boolean male = rand.nextBoolean();
        if(male) return "male" ;
        return "female" ;
    }



    public static String randomFirstName() {
        return "first_" + timeSuffix();
    }

    public static String randomLastName() {
        return "last_" + timeSuffix();
    }

    public static String randomEmail() {
        String prefix = "as" + rand.nextInt(90) + timeSuffix();
        return prefix + "@sdf.com";
    }

    public static String randomPassword() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String part1 = "" + letters.charAt(rand.nextInt(letters.length()))
                + letters.charAt(rand.nextInt(letters.length()))
                + letters.charAt(rand.nextInt(letters.length()))
                + letters.charAt(rand.nextInt(letters.length()));
        String part2 = "" + digits.charAt(rand.nextInt(digits.length()))
                + digits.charAt(rand.nextInt(digits.length()))
                + digits.charAt(rand.nextInt(digits.length()));
        return part1 + "_" + part2 + timeSuffix();
    }
}

