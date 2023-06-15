package Utility;

import java.util.Random;

public class RandomNames {
    private static String[] firstNames = {"John", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Robin"};
    private static String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood"};
    private static Random random = new Random();

    public String GenerateRandomName(){
        String randomName = firstNames[random.nextInt(firstNames.length)];
        String randomnn=lastNames[random.nextInt(lastNames.length)];
        System.out.println("Random name: " + randomName);
        System.out.println("Random name: " + randomnn);
        return randomName;
    }
}
