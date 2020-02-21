package exceptions;

public class InvalidArgumentTypeException extends Exception {

    String normalType, currentType;
    String operation;
    Object value;

    public InvalidArgumentTypeException(String operation, String normal, String current, Object val) {
        super("InvalidArgumentTypeException");
        this.normalType = normal;
        this.currentType = current;
        this.operation = operation;
        this.value = val;
    }

    @Override
    public String getMessage() {
        return  "Incorrect argument type for operation \"" + operation +
                "\" : value \"" + value + "\" has type " + currentType + " instead of " + normalType;
    }
}
