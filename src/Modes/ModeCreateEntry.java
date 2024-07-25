package Modes;
import Utility.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ModeCreateEntry implements Mode{

    private String[] args;
    private final SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
    public static final String CREATE_ENTRY = "INSERT INTO Сотрудники(ФИО, Дата_рождения, Пол) VALUES (?, ?, ?)";
    public ModeCreateEntry(String[] args){
        this.args = args;
    }
    @Override
    public void execute(Connection connection) throws SQLException{
            try{
                Date date = format.parse(args[2]);
                Employee employee = new Employee(args[1], date, args[3]);
                employee.loadToDb(connection);
            }catch (ParseException e){
                e.printStackTrace();
                System.out.println("Ошибка при парсинге даты");
            }
    }
}