package Modes;
import java.sql.*;

public class ModeMakeSelection implements Mode {
    private final String makeSelection = "SELECT * FROM" +
            " Сотрудники WHERE Пол = 'Male' and ФИО LIKE 'F%'";

    @Override
    public void execute(Connection connection) throws SQLException {
        long start = System.currentTimeMillis();
        PreparedStatement statement = connection.prepareStatement(makeSelection);
// ...
        ResultSet resultSet = statement.executeQuery();
        int cnt = 0;
        while (resultSet.next()) {
            String fullname = resultSet.getString("ФИО");
            Date birthDate = resultSet.getDate("Дата_рождения");
            String gender = resultSet.getString("Пол");

            System.out.println(fullname + " " + birthDate + " " + gender);
            cnt++;
        }

        long finish = System.currentTimeMillis();
        long timeSpent = finish - start;
        System.out.println("Total entries: " + cnt);
        System.out.println("Time spent: " + timeSpent + " milliseconds");
    }
}