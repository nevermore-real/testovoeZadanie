package Modes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeFastSelection implements Mode{
    private final String addIndex = "CREATE INDEX my_index ON Сотрудники (ФИО, Пол)";
    @Override
    public void execute(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(addIndex);
        statement.close();

        //added new index and now repeat our selection

        ModeMakeSelection makeSelection = new ModeMakeSelection();
        makeSelection.execute(connection);

    }
}
