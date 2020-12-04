package planetarium.exceptions;

public class IncorrectDayNumberException extends RuntimeException  { 
    public IncorrectDayNumberException(String errorMessage) {
        super(errorMessage);
    }
}


