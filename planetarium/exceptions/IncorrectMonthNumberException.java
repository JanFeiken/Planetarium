package planetarium.exceptions;

public class IncorrectMonthNumberException extends RuntimeException  { 
    public IncorrectMonthNumberException(String errorMessage) {
        super(errorMessage);
    }
}
