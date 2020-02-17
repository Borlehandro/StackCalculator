package commands;

public class PrintCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList,CalculationContext context) {

        System.err.println(context.getTop());

    }
}
