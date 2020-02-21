package exceptions;

public class InvalidArgumentTypeException extends ExecuteTimeException {

    String normalType, currentType;
    String operation;
    Object value;

    public InvalidArgumentTypeException(String operation, String normal, String current, Object val, long step) {
        super(step);
        this.normalType = normal;
        this.currentType = current;
        this.operation = operation;
        this.value = val;
    }

    @Override
    public String getMessage() {
        return  "Incorrect argument type for operation \"" + operation +
                "\" in step " + step + " - value \"" + value +
                "\" has type " + currentType + " instead of " + normalType;
    }
}
