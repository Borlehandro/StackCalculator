package exceptions;

public class InvalidVarNameException extends ExecuteTimeException {

    private String var;

    public InvalidVarNameException(String var, long step) {
        super(step);
        this.var = var;
    }

    @Override
    public String getMessage() {
        return "Can not use undefined variable: \"" + var + "\" in step " + step;
    }
}
