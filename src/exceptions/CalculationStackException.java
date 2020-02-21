package exceptions;

public class CalculationStackException extends Exception {

    @Override
    public String getMessage() {
        return "Can not pop from stack. Stack is empty!";
    }
}
