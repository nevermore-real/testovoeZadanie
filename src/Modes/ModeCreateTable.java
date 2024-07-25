package Modes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeCreateTable implements Mode{
    private final String createTable = "CREATE TABLE IF NOT EXISTS Сотрудники (" +
            "id SERIAL PRIMARY KEY," +
            "ФИО TEXT NOT NULL," +
            "Дата_рождения DATE," +
            "Пол TEXT NOT NULL);";
    @Override
    public void execute(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute(createTable);
        statement.close();
        System.out.println("Table created");
    }
}
