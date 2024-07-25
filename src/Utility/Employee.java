package Utility;
import Modes.ModeAutofill;
import Modes.ModeCreateEntry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Employee {
    private String fullname;
    Date birthDate;
    private String gender;

    public Employee(String name, Date date, String gender){
        this.fullname = name;
        this.birthDate = date;
        this.gender = gender;
    }
    public static int countAge(Date birthDate) {
                LocalDate date = new java.sql.Date(birthDate.getTime()).toLocalDate();
                return Period.between(date, LocalDate.now()).getYears();
    }
    public void loadToDb(Connection connection) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(ModeCreateEntry.CREATE_ENTRY);
        statement.setString(1, fullname);
        statement.setDate(2, new java.sql.Date(birthDate.getTime()));
        statement.setString(3, gender);
        statement.execute();
        statement.close();
        System.out.println("Entry added" + " " + ModeAutofill.counter);

    }
}
