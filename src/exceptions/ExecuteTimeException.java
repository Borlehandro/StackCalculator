package exceptions;

public abstract class ExecuteTimeException extends Exception {

    protected long step;

    ExecuteTimeException(long step) {
        this.step = step;
    }
}
