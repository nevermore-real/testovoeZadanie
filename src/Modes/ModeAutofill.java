package Modes;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.IntStream;

public class ModeAutofill implements Mode{

    private final int ITERATIONS_NUMBER = 1000000;
    private final int ITERATIONS_NUMBER_SECOND = 100;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int lettersAmount = 26;
    private int[] lettersCountList = new int[lettersAmount];
    public static int counter = 0;
    final Random random = new Random();

    @Override
    public void execute(Connection connection) throws SQLException {
        for (int i = 0; i < ITERATIONS_NUMBER; i++){
            String fullname = getRandomName(false) + " " + getRandomName(false) + " " + getRandomName(false);
            String date = getRandomDate();
            String gender = getRandomGender();
            String[] args = {"4",fullname, date, gender};
            ModeCreateEntry createEntry = new ModeCreateEntry(args);
            createEntry.execute(connection);
            counter++;
        }

        for (int i = 0; i < ITERATIONS_NUMBER_SECOND; i++){
            String fullname = getRandomName(false) + " " + getRandomName(true) + " " +getRandomName(false);
            String date = getRandomDate();
            String gender = "Male";
            String[] args = {"4",fullname, date, gender};                      //todo remove repeats
            ModeCreateEntry createEntry = new ModeCreateEntry(args);
            createEntry.execute(connection);
            counter++;
        }
    }
    public String getRandomName(boolean flag){
        StringBuilder builder = new StringBuilder();
        int length = random.nextInt(4) + 2;


        if (flag) builder.append("F");
        else {
            //first letter distribution

            int min = IntStream.of(lettersCountList).min().getAsInt();
            int minIndex = Arrays.stream(lettersCountList).boxed().toList().indexOf(min);
            String firstLetter = String.valueOf(alphabet.charAt(minIndex)).toUpperCase();
            builder.append(firstLetter);
            lettersCountList[minIndex] += 1;
        }

        for (int j = 0; j < length; j++){
            builder.append(alphabet.charAt(random.nextInt(lettersAmount)));
        }
        return builder.toString();
    }
    public String getRandomDate(){

            GregorianCalendar calendar = new GregorianCalendar();
            int year = randomBetween(1900, 2023);
            calendar.set(Calendar.YEAR, year);
            int dayOfYear = randomBetween(1, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
            calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

            return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);

        }
    public int randomBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    public String getRandomGender() {
        String[] genders = {"Male", "Female"};
        return genders[random.nextInt(2)];
    }
}
