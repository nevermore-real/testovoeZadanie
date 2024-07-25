
import Exceptions.MyException;
import Modes.Mode;
import Modes.ModeMap;
import Utility.DatabaseHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        ModeMap map = new ModeMap(args);
        try{
            Mode mode = map.get(args);
            Connection connection = new DatabaseHandler().connectToDatabase();
            mode.execute(connection);
        } catch (MyException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
}