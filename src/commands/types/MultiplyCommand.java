package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentsCountException;

public class MultiplyCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context) throws InvalidArgumentsCountException {

        if (argumentsList.size() != 0)
            throw new InvalidArgumentsCountException();
        // Todo add exceptions
        context.push(context.pop() * context.pop());

    }
}
