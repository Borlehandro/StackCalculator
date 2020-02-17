package commands;

public class PlusCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList) {
        System.out.println("Try to execute +");
    }
}
