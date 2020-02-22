package exceptions;

public class UnknownCommandException extends Exception {

    private String command;

    public UnknownCommandException(String command) {
        this.command = command;
    }

    @Override
    public String getMessage() {
        return "Can't create operation with unknown command: \"" + command + "\"";
    }
}