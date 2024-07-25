package Modes;

import Utility.Employee;

import java.sql.*;

public class ModePrintAll implements Mode{
    private final String makeSelection = "SELECT * FROM (" +
            "SELECT  *, ROW_NUMBER() OVER (PARTITION BY ФИО, Дата_рождения) rn " +
            "FROM Сотрудники" +
            ") AS f WHERE rn = 1 ORDER BY ФИО DESC";
    @Override
    public void execute(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(makeSelection);
        while (resultSet.next()){
            String fullname = resultSet.getString("ФИО");
            Date birthDate = resultSet.getDate("Дата_рождения");
            String gender = resultSet.getString("Пол");
            int age = Employee.countAge(birthDate);

            System.out.println(fullname + " " +  birthDate + " " + gender + " " + age);
        }
        statement.close();
    }
}
