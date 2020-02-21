package exceptions;

public class InvalidVarNameException extends Exception {

    private String var;

    public InvalidVarNameException(String var) {
        super("InvalidVarNameException");
        this.var = var;
    }

    @Override
    public String getMessage() {
        return "Can not use undefined variable: \"" + var + "\"";
    }
}
