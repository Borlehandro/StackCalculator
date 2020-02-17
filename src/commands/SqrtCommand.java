package commands;

import exceptions.InvalidArgumentsCountException;

public class SqrtCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList,CalculationContext context) throws InvalidArgumentsCountException {

        if (argumentsList.size() != 0)
            throw new InvalidArgumentsCountException();
        // Todo add exceptions
        context.push(Math.sqrt(context.pop()));

    }
}
