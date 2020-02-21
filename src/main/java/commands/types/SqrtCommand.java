package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentsCountException;

public class SqrtCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, CalculationStackException {

        if (argumentsList.size() != 0)
            throw new InvalidArgumentsCountException("SQRT", 0, argumentsList.size(), context.getStep());

        // Todo complex square?
        context.push(Math.sqrt(context.pop()));

    }
}
