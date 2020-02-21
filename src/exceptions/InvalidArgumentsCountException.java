package exceptions;

public class InvalidArgumentsCountException extends ExecuteTimeException {

    private int normal, current;
    private String operation;

    public InvalidArgumentsCountException(String operation, int normal, int current, long step) {
        super(step);
        this.normal = normal;
        this.current = current;
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Incorrect arguments number for operation \"" + operation + "\" in step " + step + " - " + current + " instead of " + normal;
    }

}
