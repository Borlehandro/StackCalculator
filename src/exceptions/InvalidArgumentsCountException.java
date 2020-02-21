package exceptions;

public class InvalidArgumentsCountException extends Exception {

    int normal, current;
    String operation;

    public InvalidArgumentsCountException(String operation, int normal, int current) {
        super("InvalidArgumentsCountException");
        this.normal = normal;
        this.current = current;
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Incorrect arguments number for operation \"" + operation + "\" : " + current + " instead of " + normal;
    }

}
