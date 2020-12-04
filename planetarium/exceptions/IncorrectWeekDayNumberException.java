package planetarium.exceptions;

public class IncorrectWeekDayNumberException extends RuntimeException {
	public IncorrectWeekDayNumberException(String errorMessage) {
        super(errorMessage);
    }
}
