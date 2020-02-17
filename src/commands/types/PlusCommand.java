package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentsCountException;

import java.util.EmptyStackException;

public class PlusCommand implements Command {

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, EmptyStackException {

        if (argumentsList.size() != 0)
            throw new InvalidArgumentsCountException();
        // Todo How to catch it !?
        try {
            context.push(context.pop() + context.pop());
        } catch (EmptyStackException e) {
            throw new EmptyStackException();
        }

    }
}
