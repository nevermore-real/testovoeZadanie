package Utility;
import java.util.Arrays;

public class Checker {
    public static boolean checkInputMode(String[] args){
        String[] availableModes = {"1", "2", "3", "4", "5", "6"};
        if (args.length == 0) return false;
        if (!args[0].equals("2") && args.length != 1) return false;
        if (args[0].equals("2") && args.length != 4) return false;
        String mode = args[0];
        return Arrays.asList(availableModes).contains(mode);

        //should be more checks here
    }
}
