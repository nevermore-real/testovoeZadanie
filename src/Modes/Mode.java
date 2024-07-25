package Modes;

import java.sql.Connection;
import java.sql.SQLException;

public interface Mode {
    void execute (Connection connection) throws SQLException;
}
