package commands;

import exceptions.InvalidArgumentsCountException;

public class DefineCommand implements Command {

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException {

        if (argumentsList.size() != 2)
            throw new InvalidArgumentsCountException();
        context.define(argumentsList.get(0), Double.valueOf(argumentsList.get(1)));

    }
}
