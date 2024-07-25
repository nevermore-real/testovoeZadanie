package Modes;
import Exceptions.WrongInputException;
import Utility.Checker;
import java.util.HashMap;

public class ModeMap {

    HashMap<String, Mode> map;

    public ModeMap(String[] args){
        this.map = new HashMap<>();
        map.put("1", new ModeCreateTable());
        map.put("2", new ModeCreateEntry(args));
        map.put("3", new ModePrintAll());
        map.put("4", new ModeAutofill());
        map.put("5", new ModeMakeSelection());
        map.put("6", new ModeFastSelection());
    }
    public Mode get (String[] args) throws WrongInputException {
        if (!Checker.checkInputMode(args)) throw new WrongInputException("Неверный ввод");
        return map.get(args[0]);

    }
}
