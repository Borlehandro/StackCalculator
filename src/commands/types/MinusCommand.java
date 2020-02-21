package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentsCountException;

public class MinusCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context) throws InvalidArgumentsCountException, CalculationStackException {

        if (argumentsList.size() != 0)
            throw new InvalidArgumentsCountException("-", 0, argumentsList.size());

        context.push(context.pop() - context.pop());

    }
}
