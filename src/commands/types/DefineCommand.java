package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;

public class DefineCommand implements Command {

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, InvalidArgumentTypeException {

        if (argumentsList.size() != 2)
            throw new InvalidArgumentsCountException("DEFINE", 2, argumentsList.size());
        try {
            context.define(argumentsList.get(0), Double.valueOf(argumentsList.get(1)));
        } catch (NumberFormatException e) {
            throw new InvalidArgumentTypeException("DEFINE", "Double", "String", argumentsList.get(1));
        }

    }
}
