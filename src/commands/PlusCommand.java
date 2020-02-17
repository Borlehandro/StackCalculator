package commands;

import exceptions.InvalidArgumentsCountException;

public class PlusCommand implements Command {

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException {

        if (argumentsList.size() != 0)
            throw new InvalidArgumentsCountException();
        // Todo add exceptions
        context.push(context.pop() + context.pop());
    }
}
