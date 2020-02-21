package exceptions;

public class CalculationStackException extends ExecuteTimeException {

    public CalculationStackException(long step) {
        super(step);
    }

    @Override
    public String getMessage() {
        return "Can not pop from stack in step "+ step +". Stack is empty!";
    }
}
